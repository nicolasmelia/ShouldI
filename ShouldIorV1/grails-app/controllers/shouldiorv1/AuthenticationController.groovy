package shouldiorv1

import com.google.gson.Gson
import com.google.gson.JsonObject
import java.beans.WeakIdentityMap.Entry
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class AuthenticationController {

    def index() {
		render("You do not have permission to view this page")
	}
	
	
	// ********************* LOGIN USING FACEBOOK API *********************
	def loginFaceBook() {
		
		User tempUser = new User()
		User user = User.findByUserID(params.userID)
		
		if (user != null) {
			if (session["userID"] == null) {
				if (!user.token.matches(params.token)){
					// Token has been changed. Update it.					
					user.token = params.token
					user.save(flush:true); 
				}
			}
			
			tempUser = user;
						
		} else {
			// User does not exist in our DB, create them an account
			User newUser = new User();
			newUser.userID = params.userID
			newUser.token = params.token
			newUser.accountType = "Facebook"
			newUser.password = "NONE"
			newUser.peopleReached = 0
			newUser.totalQuestions = 0
			newUser.about = "Apparently, this user prefers to keep an air of mystery about them."
			newUser.deleted = false
			newUser.followerCount = 0
			newUser.certified = false
			newUser.dateCreated = new Date()
			newUser.loginName = ""
			newUser.name = getFaceBookName(params.userID, params.token)
			newUser.save(flush:true);
			tempUser = newUser;
		}
		
		if (tempUser.deleted == false) {
			// Create their session
			session["userID"] = tempUser.userID
			session["name"] = tempUser.name.trim()		
			if  (session["name"]) {
			render "Success"
			} else {
			render "Fail"
			}
		} else {
			render "Fail"
		}
	}
	
	
	// ********************* READ FROM FACEBOOK GRAPH API *********************
	
	def getFaceBookName(String userID, String token) {	
		URL url = new URL("https://graph.facebook.com/v1.0/" + userID +  "/?access_token=" + token);	
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String jsonString;
			jsonString = br.readLine();
			br.close();
			
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
			return jsonObject.get("name").toString().replaceAll("\""," ").trim(); 
		  }
	
	
	
	// ********************* LOGIN USING REDDIT API *********************
	def loginReddit() {
		if (!session["userID"]) {
			render(view: "loginReddit")	
		} else {
			redirect(action: "home", controller: "shouldI")	
		}
	}
	
	def loginRedditAttempt() {
		boolean loginSuccess = false
		boolean errorThrown = false // for reddits 429
		
		if (!session["userID"]) {
			String user = params.username
			String pw = params.password
			try {		
				// Reddit api sends error 429 too often. Attempt 10 times before giving up.
				for (int i = 0; i < 10; i++) {
					if (loginSuccess == false) {
					try {
						loginSuccess = requestRedditLogin(user, pw)
						} catch(Exception ex2) {
							errorThrown = true;
						 // Do nothing, code 429 thrown
						}
					}
					if (loginSuccess == true || !errorThrown) {
						break;		
					}
				}			
			} catch (Exception ex) {
				// Nothing right now
			} finally {
				if (loginSuccess) {
					createRedditSession(user) // renders success and redirects
				} else {
					render (view: "loginReddit", model:["Success":loginSuccess])
				}
			}
		} else {
			render (view: "loginReddit", model:["Success":loginSuccess])
		}
		
	}
	
	def requestRedditLogin(user, pw){
		URL url = new URL( "https://ssl.reddit.com/api/login/myusername" );
		String data = "api_type=json&user=" + user + "&passwd=" + pw;
		HttpURLConnection ycConnection = null;
		ycConnection = ( HttpURLConnection ) url.openConnection();
		ycConnection.setRequestMethod( "POST" );
		ycConnection.setDoOutput( true );
		ycConnection.setUseCaches( false );
		ycConnection.setRequestProperty( "Content-Type",
			"application/x-www-form-urlencoded; charset=UTF-8" );
		ycConnection.setRequestProperty( "Content-Length", String.valueOf( data.length() ) );

		DataOutputStream wr = new DataOutputStream(
			ycConnection.getOutputStream() );
		wr.writeBytes( data );
		wr.flush();
		wr.close();
		InputStream is = ycConnection.getInputStream();
		BufferedReader rd = new BufferedReader( new InputStreamReader( is ) );
		String line;
		StringBuffer response = new StringBuffer();
		while ( ( line = rd.readLine() ) != null )
		{
			response.append( line );
			response.append( '\r' );
		}

		rd.close();
		
		Gson gson = new Gson();
		
		// Get the wrong password response from reddits response. Yes this is json in json
		JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);
		
		if (jsonObject.get("json").toString().contains("wrong password")) {
			// wrong password
			return false
		} else if (jsonObject.get("json").toString().contains("modhash"))   {
			// Success login
			return true
		} else {
			// who knows
			return false
		} 
		
		
	}
	
	def createRedditSession(name) {
		User tempUser = new User()
		User user = User.findByLoginName(name.toString().toLowerCase()) // Should be userID!!!! REDDIT IS NOT COMPLETE!!!
		
		if (user != null) {
			tempUser = user;				
		} else {
			// User does not exist in our DB, create them an account
			User newUser = new User();
			
			// Generate a unique ID
			while(true) {
				// Create a UUID and cut it in half for easier reading
				String uniqueID = UUID.randomUUID().toString().replace("-", "");
				int midpoint = uniqueID.length() / 2;
				String halfUUID = uniqueID.substring(0, midpoint)
				int matchCount = Question.countByUserID(halfUUID)
				if (matchCount == 0) {		
					newUser.userID = halfUUID
					break;
				 }
			}
			
			newUser.token = "REDDITNONE"
			newUser.accountType = "Reddit"
			newUser.password = "NONE"
			newUser.peopleReached = 0
			newUser.totalQuestions = 0
			newUser.about = "Apparently, this user prefers to keep an air of mystery about them."
			newUser.dateCreated = new Date()
			newUser.followerCount = 0
			newUser.deleted = false
			newUser.certified = false
			newUser.loginName = name.toString().toLowerCase()
			newUser.name = name.toString().toLowerCase()
			newUser.save(flush:true);
			tempUser = newUser;
		}
		
		if (tempUser.deleted == false) {		
			// Create their session
			session["userID"] = tempUser.userID
			session["name"] = tempUser.name	
			redirect(action: "home", controller: "shouldI")		
		} else {
			redirect(action: "thisIsNotGood", controller: "shouldI")
		}
	}
	
	
	
	// ********** SEED ACCOUNT **********
	
	def loginSeed() {
		render(view:"seedLogin")	
	}
	
	def loginSeedAccount() {
		String name = params.username.toString().trim()
		User tempUser = new User()
		User user = User.findByLoginName(name) // 
		
		if (user != null) {
			
			tempUser = user;
						
		} else {
			// User does not exist in our DB, create them an account
			User newUser = new User();
			
			// Generate a unique ID
			while(true) {
				// Create a UUID and cut it in half for easier reading
				String uniqueID = UUID.randomUUID().toString().replace("-", "");
				int midpoint = uniqueID.length() / 2;
				String halfUUID = uniqueID.substring(0, midpoint)
				int matchCount = Question.countByUserID(halfUUID)
				if (matchCount == 0) {
					newUser.userID = halfUUID
					break;
				 }
			}
			
			newUser.token = "SEEDNONE"
			newUser.accountType = "Seed"
			newUser.password = "NONE"
			newUser.peopleReached = 0
			newUser.totalQuestions = 0
			newUser.about = "Apparently, this user prefers to keep an air of mystery about them."
			newUser.dateCreated = new Date()
			newUser.followerCount = 0
			newUser.deleted = false
			newUser.certified = false
			newUser.loginName = name
			newUser.name = name
			newUser.save(flush:true);
			tempUser = newUser;
		}
		
		// Create their session
		session["userID"] = tempUser.userID
		session["name"] = tempUser.name
		redirect(action: "home", controller: "shouldI")
		

	}
	
	
	

	// ********************* LOG OUT *********************
	def logout () {
		User user = User.findByUserID(session["userID"])
		session.invalidate()
		render "Success:" + user.accountType
	}
	
	
	
}

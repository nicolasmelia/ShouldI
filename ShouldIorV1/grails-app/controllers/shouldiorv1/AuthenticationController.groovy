package shouldiorv1

import com.google.gson.Gson
import com.google.gson.JsonObject
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
			newUser.userName = null
			newUser.name = getFaceBookName(params.userID, params.token)
			newUser.save(flush:true);
			tempUser = newUser;
			print "Created"
		}
		
		// Create their session
		session["userID"] = tempUser.userID
		
		if (tempUser.userName != null) {
			// Name has been changed to an alias display name
			session["name"] = tempUser.userName
			} else {
			try {
			session["name"] = tempUser.name.trim().split(" ")[0]
			} catch (Exception ex) {
			session["name"] = tempUser.name.trim()
			}
		}
		
		if  (session["name"]) {
		render "Success"
		} else {
		render "Fail"
		}
	}
	
	def test(){
		print "HITME" +  params.userID + " " + params.token
		render (params.userID + " " + params.token)
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
	

	// ********************* LOG OUT *********************
	def logout () {
		session.invalidate()
		render "Success"
	}
	
	
	
}

package shouldiorv1

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage
import org.apache.commons.compress.utils.*;

class UserController {
	// This allows us to config database from url
	//static scaffold = true

	
		def myProfile() {						
			User user = User.findByUserID(session['userID']);
			// Configure off pagination 
			if (params.category == null) {
				params.category = "My Questions"
			}	
			
			int offset
			if (params.offset == null) {
				offset = 0
			} else {
				offset = Integer.parseInt(params.offset);
			}	
			
			if (params.up.toString().matches("true")) {
				offset = offset + 10
			} else if (params.up.toString().matches("false"))  {
			if (offset != 0) { // Dont allow offset to go below 0
				offset = offset - 10
			} 
			} else if (params.up.toString().matches("reset"))  {
				offset = 0
			} 
			
			def users = new ArrayList<User>()
			def questions = new ArrayList<Question>()
			switch (params.category) {
				case "My Questions": 
					questions = Question.findAll("from Question as q where q.userID  = ? order by date DESC", [session['userID']], [max: 10, offset: offset])
				break;
				case "My Notifications":
					questions = Question.findAll("from Question as q where q.userID = ? and q.opNotifyVoteCount > 0 order by q.opNotifyVoteCount DESC", [session['userID']], [max: 10, offset: offset])		
				break;	
				case "My Favorites":
				def favorites = Favorite.findAll("from Favorite as f where f.userID = ? AND f.favType = ? order by f.dateAdded DESC", [session["userID"], 'Question'], [max: 10, offset: offset])
				for (Favorite favorite : favorites) {
					def question = Question.findByQuestionID(favorite.questionID)
					questions.add(question)
				}	
				break;	
				case "Following":
					def favorites = Favorite.findAll("from Favorite as f where f.userID = ? and f.favType = ? order by f.dateAdded DESC", [session["userID"], 'User'], [max: 10, offset: offset])
					for (Favorite favorite : favorites) {
						def userCash = User.findByUserID(favorite.userIDFollowing)
						users.add(userCash)
					}
				break;	
			}
			
			def opQuestionCount = Question.countByUserID(session['userID'])
			render (view: "myProfile", model: ["question": questions, "users": users, "offset" : offset, "category" : params.category, "user" : user, "notifyCount": getNotifyCount()])	
	}
		

		// View others profiles
	def profile() {				
		// Get profile information
		User user = User.findByUserID(params.id);
		
		// Configure off pagination
		if (params.category == null) {
			params.category = "New Questions"
		}
		
		int offset
		if (params.offset == null) {
			offset = 0
		} else {
			offset = Integer.parseInt(params.offset);
		}
		
		if (params.up.toString().matches("true")) {
			offset = offset + 10
		} else if (params.up.toString().matches("false"))  {
		if (offset != 0) { // Dont allow offset to go below 0
			offset = offset - 10
		}
		} else if (params.up.toString().matches("reset"))  {
			offset = 0
		}
		
		def users = new ArrayList<User>()
		def questions = new ArrayList<Question>()
		switch (params.category) {
			case "New Questions":
				questions = Question.findAll("from Question as q where q.userID = ? ORDER BY q.date DESC", [user.userID], [max: 10, offset: offset])
			break;
			case "Top Questions":
				questions = Question.findAll("from Question as q where q.userID = ? ORDER BY q.totalVotes DESC", [user.userID], [max: 10, offset: offset])
			break;
				case "Favorites":
				def favorites = Favorite.findAll("from Favorite as f where f.userID = ? AND f.favType = ? order by f.dateAdded DESC", [user.userID, 'Question'], [max: 10, offset: offset])
				for (Favorite favorite : favorites) {
					def question = Question.findByQuestionID(favorite.questionID)
					questions.add(question)
				}	
				break;
			case "Following":
			def favorites = Favorite.findAll("from Favorite as f where f.userID = ? and f.favType = ? order by f.dateAdded DESC", [user.userID, 'User'], [max: 10, offset: offset])
			for (Favorite favorite : favorites) {
				def userCash = User.findByUserID(favorite.userIDFollowing)
				users.add(userCash)
			}
			break;
		}
		
		// See is user is being followed by session user viewing
		boolean following = false		
		if (session['userID'] != null) {
			def favoriteUser = Favorite.findByUserIDAndFavTypeAndUserIDFollowing(session['userID'], "User", user.userID)
			if (favoriteUser != null) {
					following = true
				}
		} 
		
		
		
		// Query for questions
		render (view: "profile", model: ["question": questions, "users": users, "offset" : offset, "category" : params.category, "user" : user, "notifyCount": getNotifyCount(), "following": following])

}
	
	def editProfile() {
		User user = User.findByUserID(session['userID'])
		
		// About may not have been set
		if (user.about == null) {
			user.about = ""
		}
		
		render(view: "editProfile", model: ["user": user, "notifyCount": getNotifyCount()])		
	}
	
	def updateProfile() {
		User user = User.findByUserID(session['userID']);	
		
		if (params.aboutText.toString().length() < 300 ) {		
			if (params.aboutText.toString().trim().length() < 3){
				user.about = "Apparently, this user prefers to keep an air of mystery about them."
			} else {
				user.about = params.aboutText.toString().trim()			
			}
		}	
		
		if (!user.name.equals(params.name.toString().trim()) && params.username.toString().length() <= 25 && params.username.toString().length() > 3) {
			user.name = params.name.toString().trim()
			session["name"] = user.name
			//Update all questions the user has posted with their new username
			def questions = Question.findAllByUserID(user.userID)	
			for (Question question : questions){
				question.userName = params.name.toString().trim()
				question.save(flush:true)
			}
		}
		
		user.save(flush:true)		
		
		// Renders user profile
		redirect(action: "myProfile")
	}
	
	def checkUserName() {
		int userCount = User.countByName(params.name.toString().trim());
		if (userCount == 0) {
				render "True"	
		} else {
			if (params.name.toString().trim().equals(session["name"])) {
				render "True" // Its their username!
			} else {
				render "False" 
			}	
		}
	}
		
	def getProfileImage() {
	try {
		User user = User.findByUserID(params.id);	
		if (user != null) {
			if (user.avatar != null) {
				// If user avatar is from our system
				response.outputStream << user.avatar
				response.outputStream.flush()	
			} else if (user.accountType.matches("Facebook")) {
				// if user account is from facebook
				response.outputStream << ImgURLToByte("https://graph.facebook.com/" + user.userID + "/picture?type=large")
				response.outputStream.flush()
			} else if (user.accountType.matches("Reddit")) {				
				response.outputStream << grailsAttributes.getApplicationContext().getResource("images/blankAv.png").getFile().bytes
				response.outputStream.flush()
				// TODO: twitter, ect
			}
			
		} else {
			// Render no profile image	
			response.outputStream << grailsAttributes.getApplicationContext().getResource("images/blankAv.png").getFile().bytes
			response.outputStream.flush()
		}		
	} catch (Exception ex) {
		response.outputStream << grailsAttributes.getApplicationContext().getResource("images/blankAv.png").getFile().bytes
		response.outputStream.flush()
	}
	}
	
	def ImgURLToByte(String urlString) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is = null;
		URL url = new URL(urlString);
		
		try {
		  is = url.openStream ();
		  byte[] byteChunk = new byte[4096]; // Or whatever size you want to read in at a time.
		  int n;
		
		  while ( (n = is.read(byteChunk)) > 0 ) {
		    baos.write(byteChunk, 0, n);
		  }
		}
		catch (IOException e) {
		  System.err.printf ("Failed while reading bytes from %s: %s", url.toExternalForm(), e.getMessage());
		  e.printStackTrace ();
		  // Perform any other exception handling that's appropriate.
		}
		
		finally {
		  if (is != null) { is.close(); }
		}
		
		return baos.toByteArray()
	}
	
	def getNotifyCount() {
		// get the op notification count
		def notifyCount = "";
		if (session["userID"] != null) {
		 def notifyCountResult =  Question.executeQuery("select COUNT(*) from Question a where a.opNotifyVoteCount > 0 AND a.userID = ?", [session['userID']])
		 notifyCount = notifyCountResult.toString().replaceAll("\\[", "").replaceAll("\\]","");
		}
		return notifyCount
	}
	
	// Follow a user
	def followUser() {
		// Adds question to logged in users favorites
		if (session["userID"] != null) {
			User user = User.findByUserID(session["userID"])
			Favorite favoriteExist = Favorite.findByFavTypeAndUserIDAndUserIDFollowing("User", session["userID"], params.favUserID)
			if (!favoriteExist) {
				
				// increment favuserIds follow count
				User favedUser = User.findByUserID(params.favUserID)
				favedUser.followerCount = favedUser.followerCount + 1
				favedUser.save(flush:true)
				
				// Add fav
				Favorite favorite = new Favorite();
				favorite.userIDFollowing = params.favUserID
				favorite.favType = "User"
				favorite.userID = session["userID"]
				favorite.dateAdded = new Date();
				favorite.save(flush:true)

			
				render ("Added")
			} else if (favoriteExist) {
			
				favoriteExist.delete(flush:true)
				
				// increment favuserIds follow count
				User favedUser = User.findByUserID(params.favUserID)
				if (favedUser.followerCount > 0) {
				favedUser.followerCount = favedUser.followerCount - 1
				favedUser.save(flush:true)
				}
				
				render ("Deleted")
			} else {
				render ("False")  // who knows
			}
		} else {
			render ("False") // Not logged in
		}
	}
	

}

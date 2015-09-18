package shouldiorv1

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage
import org.apache.commons.compress.utils.*;

class UserController {
	// This allows us to config database from url
	static scaffold = true

	
		def myProfile() {	
					
			User user = User.findByUserID(session.userID);
			
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
			
			def questions
			switch (params.category) {
				case "My Questions": 
					questions = Question.findAll("from Question as q where q.userID =" + session['userID'],  [max: 10, offset: offset])
				break;
				case "My Notifications":
					questions = Question.findAll("from Question as q where q.userID =" + session['userID'] + "and q.opNotifyVoteCount > 0 order by q.opNotifyVoteCount DESC",  [max: 10, offset: offset])		
				break;	
				case "My Favorites":
					questions = Question.findAll("from Question as q where q.userID =" + session['userID'],  [max: 10, offset: offset])
				break;	
			}
			
			def opQuestionCount = Question.countByUserID(session['userID'])
			
			// Query for questions
			render (view: "myProfile", model: ["question": questions, "offset" : offset, "category" : params.category, "opQuestionCount" : opQuestionCount, "user" : user])	
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
		
		def questions
		switch (params.category) {
			case "New Questions":
				questions = Question.findAll("from Question as q where q.userID =" + user.userID,  [max: 10, offset: offset])
			break;
			case "Top Questions":
				questions = Question.findAll("from Question as q where q.userID =" + user.userID + "and q.opNotifyVoteCount > 0 order by q.opNotifyVoteCount DESC",  [max: 10, offset: offset])
			break;
		}
		

		def opQuestionCount = Question.countByUserID(params.id)
		
		// Query for questions
		render (view: "profile", model: ["question": questions, "offset" : offset, "category" : params.category, "user" : user, "opQuestionCount" : opQuestionCount])

}
	
	
	def getProfileImage() {
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
			} else {
				// TODO: twitter, ect
			}
			
		} else {
			// Render no profile image	
		print "OUCH"
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
	
}

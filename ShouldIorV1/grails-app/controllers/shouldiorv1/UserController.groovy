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

	
	def getProfileImage() {
		User user = User.findByUserID(params.id);	
		print "UI:" +  params.id
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

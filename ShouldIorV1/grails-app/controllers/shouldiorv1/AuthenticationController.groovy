package shouldiorv1

class AuthenticationController {

    def index() {
		render("You do not have permission to view this page")
	}
	
	def loginFaceBook() {
		
		User user = User.findByUserID(params.userID)
		
		if (user != null) {
		// User exist, load them up!
			
			
		} else {
		// User does not exist in our DB, create them an account
		User newUser = new User();
		newUser.userID = params.userID
		
		}
		
		
		session["userID"] = params.userID
		
		
		
	}
	
	
	
}

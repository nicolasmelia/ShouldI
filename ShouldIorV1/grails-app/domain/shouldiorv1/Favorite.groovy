package shouldiorv1

class Favorite {
	
	String userID

	Date dateAdded
	
	// either Question or User
	String favType
		
	// if fav is a question
	String questionID	
	
	// if fav is a user
	String userIDFollowing

    static constraints = {
		userIDFollowing(nullable:true)
		questionID(nullable:true)
		favType(nullable:true)
    }
}

package shouldiorv1

class Vote {
	// Used for views, comments and questions
	
	int vote // Either 0, 1 or -1
	
	String voteType // Either comment or question or a view
	String itemID // either the id of a comment or question
	
	String userID
	Date date
	
    static constraints = {
		
		
    }
}

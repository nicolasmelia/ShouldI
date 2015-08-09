package shouldiorv1

class Comment {

	String userName
	String userID // can be from facebook or us
	
	String commentID
	String comment
	int upVotes
	int downVotes
	
    static constraints = {
		upVotes(nullable:true)
		downVotes(nullable:true)
    }
}

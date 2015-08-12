package shouldiorv1

class Comment {
	// CommentID information
	String commentID
	String QuestionID // Question this comment belongs to

	String userName
	String userID // can be from facebook or us
	
	String comment
	Date date
	int upVotes
	int downVotes
	
    static constraints = {
		upVotes(nullable:true)
		downVotes(nullable:true)
		comment(maxSize: 500)	
    }
}

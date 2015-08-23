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
	int voteDiff // collection of all votes added up and down
	
    static constraints = {
		upVotes(nullable:true)
		downVotes(nullable:true)
		voteDiff(nullable:true)
		
		comment(maxSize: 500)	
    }
}

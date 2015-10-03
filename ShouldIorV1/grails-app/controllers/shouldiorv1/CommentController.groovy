package shouldiorv1

import java.util.Date;

class CommentController {

    def index() { }
	
	//static scaffold = true
	
	def postMainComment() {	
		// Get the user creating the comment
		User user = User.findByUserID(session["userID"])
			
		Comment comment = new Comment();
				
		// Generate a unique ID
		while(true) {
			// Create a UUID and cut it in half for easier reading
			String uniqueID = UUID.randomUUID().toString().replace("-", "");
			int midpoint = uniqueID.length() / 2;
			String halfUUID = uniqueID.substring(0, midpoint)
			int matchCount = Question.countByQuestionID(halfUUID)
			if (matchCount == 0) {
				comment.commentID = halfUUID
				break;
			 }
		}
		
		comment.QuestionID = params.questionID
	
		if (user.userName != null) {
			comment.userName = user.userName
		} else {
			comment.userName = user.name
		}
		
		comment.userID = user.userID
		
		comment.comment = params.comment
		comment.date = new Date()
		comment.upVotes = 0
		comment.downVotes = 0
		comment.voteDiff = 0
		
		comment.save(flush:true)
		
		render ("True")
		
	}
	
	
	
	
}

package shouldiorv1

class Question {
	
	// Id information
	String questionID
	
	// Question type
	boolean custom // True if a shouldI question, false if an or
	boolean yesOrNo // if a shouldI, is this a do-dont or yes-no
	boolean anonymous 
	boolean requireLoginToVote
	boolean deleted
	
	// Question
	String question
	String questionTitle
	String category
	
	Date date
	
	String tags
	
	// Answers
	String answerOne
	String answerTwo
	String answerThree
	String answerFour
	
	// Image for answer
	byte[] answerOneImage
	byte[] answerTwoImage
	byte[] answerThreeImage
	byte[] answerFourImage
	
	// Votes for answers
	int answerOneVotes
	int answerTwoVotes
	int answerThreeVotes
	int answerFourVotes
	
	int totalVotes
	int totalViews
	int opNotifyVoteCount // Keeps track of new unchecked votes by OP. Sets to 0 on check
	
	int totalComments
	
	// User information
	String userName
	String UserID // Either facebooks userid or ours
	String ClientAddress // Responce IP address

    static constraints = {
		
		userName(nullable:true)
		question maxSize: 200000
		tags(nullable:true)
		category(nullable:true)
		opNotifyVoteCount(nullable:true)
		deleted(nullable:true)
		
		answerOneImage(nullable:true, maxSize: 1024 * 1024 * 3 /* 2MB */)
		answerTwoImage(nullable:true, maxSize: 1024 * 1024 * 3 /* 2MB */)
		answerThreeImage(nullable:true, maxSize: 1024 * 1024 * 3 /* 2MB */)
		answerFourImage(nullable:true, maxSize: 1024 * 1024 * 3 /* 2MB */)
		
		answerOne(nullable:true)
		answerTwo(nullable:true)
		answerThree(nullable:true)
		answerFour(nullable:true)
		questionTitle(nullable:true)
		
		answerOneVotes(nullable:true)
		answerTwoVotes(nullable:true)		
		answerThreeVotes(nullable:true)
		answerFourVotes(nullable:true)
		
    }
	
	static mapping = {
		question sqlType: 'longtext'
	}
}

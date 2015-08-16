package shouldiorv1

class Question {
	
	// Id information
	String questionID
	
	// Question type
	boolean Shouldi // True if a shouldI question, false if an or
	boolean yesOrNo // if a shouldI, is this a do-dont or yes-no
	boolean anonymous 
	
	// Question
	String question
	String questionTitle
	
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
	
	// Votes for answers
	int answerOneVotes
	int answerTwoVotes
	int totalVotes
	int totalComments
	
	// User information
	String UserID // Either facebooks userid or ours
	String ClientAddress // Reponnce IP address

    static constraints = {
		
		question(maxSize: 500)
		tags(nullable:true)
		
		answerOneImage(nullable:true, maxSize: 1024 * 1024 * 2 /* 2MB */)
		answerTwoImage(nullable:true, maxSize: 1024 * 1024 * 2 /* 2MB */)
		
		answerOne(nullable:true)
		answerTwo(nullable:true)
		answerThree(nullable:true)
		answerFour(nullable:true)
		questionTitle(nullable:true)
		
		answerOneVotes(nullable:true)
		answerTwoVotes(nullable:true)		
    }
}

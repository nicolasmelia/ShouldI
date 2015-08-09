package shouldiorv1

class Question {
	
	// Question type
	boolean Shouldi // True if a shouldI question, false if an or
	boolean yesOrNo // if a shouldI, is this a do-dont or yes-no
	
	// Question
	String question
	String questionID
	Date date
	
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
	
	// User information
	String UserID // Either facebooks userid or ours
	String ClientAddress // Reponnce IP address

    static constraints = {
		answerOneImage(nullable:true, maxSize: 1024 * 1024 * 2 /* 2MB */)
		answerTwoImage(nullable:true, maxSize: 1024 * 1024 * 2 /* 2MB */)
		
		answerOne(nullable:true)
		answerTwo(nullable:true)
		answerThree(nullable:true)
		answerFour(nullable:true)
		
		answerOneVotes(nullable:true)
		answerTwoVotes(nullable:true)
		
    }
}

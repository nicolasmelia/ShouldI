package shouldiorv1

class Question {
	
	// Id information
	String questionID
	
	// Question type
	boolean custom // True if a shouldI question, false if an or
	boolean yesOrNo // if a shouldI, is this a do-dont or yes-no
	boolean quick //if this question is a quick question
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
	boolean answerOneImage
	boolean answerTwoImage
	boolean answerThreeImage
	boolean answerFourImage
	
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
	
	// Strings for readability of high numbers
	String totalVotesString
	String totalViewsString
	String opNotifyVoteCountString
	
    static constraints = {
		
		userName(nullable:true)
		question maxSize: 200000
		tags(nullable:true)
		category(nullable:true)
		opNotifyVoteCount(nullable:true)
		deleted(nullable:true)
		quick(nullable:true)
		
		
		
		answerOneImage(nullable:true)
		answerTwoImage(nullable:true)
		answerThreeImage(nullable:true)
		answerFourImage(nullable:true)
		
		answerOne(nullable:true)
		answerTwo(nullable:true)
		answerThree(nullable:true)
		answerFour(nullable:true)
		questionTitle(nullable:true)
		
		answerOneVotes(nullable:true)
		answerTwoVotes(nullable:true)		
		answerThreeVotes(nullable:true)
		answerFourVotes(nullable:true)
		
		// Strings for readability of high numbers
		totalVotesString(nullable:true)
		totalViewsString(nullable:true)
		opNotifyVoteCountString(nullable:true)
		
    }
	
	static mapping = {
		question sqlType: 'longtext'
	}
}

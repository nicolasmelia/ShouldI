package shouldiorv1

import java.util.Date;

class QuestionController {
	
	// This allows us to config database from url
	static scaffold = true
	
	// View of a single question with comments
	def shouldi() {
		def question = Question.findByQuestionID(params.id)
		// Return a max of 10 comments, offset returns starting at palce 0, sort by votes desc
		def comments = Comment.findAllByQuestionID(params.id, [max: 10, offset: 0, sort: "upVotes", order: "desc"])
		render(view: "shouldi", model: ["question": question, "comments": comments])		
	}
	
	// View of a single question with comments
	def getPopularQuestions() {
		def question = Question.findAll
		//Question.executeQuery("select distinct a.number from Account a");
		// Return a max of 10 comments, offset returns starting at palce 0, sort by votes desc
		def comments = Comment.findAllByQuestionID(params.id, [max: 10, offset: 0, sort: "upVotes", order: "desc"])
		render(view: "shouldi", model: ["question": question, "comments": comments])
	}
	
	
	
	
	// ********************* ASK SHOULD I *********************
	
	def askShouldI () {
		if (session["userID"] != null) {
		render(view: "askShouldi")
		} else {
			render "Please log in bitch"
		}
	}        
	
	def postShouldI () {
		Question question = new Question()
				
		// Generate a unique ID
		while(true) {
			String uniqueID = UUID.randomUUID().toString()
			int matchCount = Question.countByQuestionID(uniqueID)
			if (matchCount == 0) {
				question.questionID = uniqueID
				break;
			 }
		} 
	
		question.Shouldi = true
		question.yesOrNo = false
		
		if (params.anonymous != null) {
		question.anonymous = params.anonymous
		} else {
		question.anonymous = false
		}
		
		question.question = params.question
		question.questionTitle = params.title
		question.tags = params.tags
		question.date = new Date()
		
		//question.answerOne = params.answerOne
		//question.answerTwo = params.answerOne
		
		if (params.image != null) {
			def f = request.getFile('image')
				question.answerOneImage = f.bytes
		}
	
		question.answerOneVotes = 0
		question.answerTwoVotes = 0
		question.totalVotes = 0
		question.totalComments = 0
		
		question.UserID = session["userID"]
		
		question.ClientAddress = request.getRemoteAddr().toString()
		question.save(flush:true)
		render "Created"

	}
	
	
	def getAnswerOneImageById() {
		Question question = Question.findByQuestionID(params.id)
		if (question != null) {
                response.outputStream << question.answerOneImage  // write the photo to the outputstream  
                response.outputStream.flush() 
		} else {
			render "NONE"
		}
	}
	
	def getAnswerTwoImageById() {
		Question question = Question.findByQuestionID(params.id)
		if (question != null) {
				response.outputStream << question.answerTwoImage  // write the photo to the outputstream
				response.outputStream.flush()
		} else {
			render "NONE"
		}
	}
	
	
	
	
}

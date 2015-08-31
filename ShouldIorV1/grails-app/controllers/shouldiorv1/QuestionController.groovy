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
		if (question != null) {
			
		String percentDif = (calcHighDiffPercent(true,question.totalVotes,question.answerOneVotes,question.answerTwoVotes,0,0)).toString().replace(".", "")
		
		// Did they vote on this question?
		String vote
		def votes = Vote.findByUserIDAndItemID(session["userID"], question.questionID)
		if (votes !=null) {
			vote = votes.vote + ""	
		} else {
			vote = "NONE"
		}
		
		def questions = Question.findAllByTotalVotesGreaterThan(-1)
				
		render(view: "shouldi", model: ["question": question, "questionID": question.questionID, "questionArray" : questions, "percentDiff": percentDif, "vote": vote])
		
		} else {
		render "Error finding this question"
		}
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
			// Create a UUID and cut it in half for easier reading
			String uniqueID = UUID.randomUUID().toString().replace("-", "");
			int midpoint = uniqueID.length() / 2;
			String halfUUID = uniqueID.substring(0, midpoint)
			int matchCount = Question.countByQuestionID(halfUUID)
			if (matchCount == 0) {
				question.questionID = halfUUID
				break;
			 }
		} 
	
		question.custom = false
		question.yesOrNo = true // This is a YES/NO question
		
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
	
	
	
	// ********************* ASK SHOULD I CUSTOM *********************
	
	def askShouldICustom() {
		if (session["userID"] != null) {
		render(view: "askshouldiCustom")
		} else {
			render "Please log in bitch"
		}
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
	
	
	def questionVote() {
		if (session["userID"] != null) {
		def votes = Vote.findAllByUserIDAndItemID(session["userID"], params.questionID)
		if (votes.size() == 0) {
			// Create a vote
			Vote vote = new Vote()
			vote.userID = session["userID"]
			vote.itemID = params.questionID
			vote.voteType = "Question"
			vote.date = new Date()
			
			// User has not votes on this question. Allow it.
			def question = Question.findByQuestionID(params.questionID)
			if (question.yesOrNo) {
			// *********** YES/NO question vote ***********
			if (params.vote.toString().matches("1")) {
				vote.vote = 1
				question.answerOneVotes = question.answerOneVotes + 1
			} else if (params.vote.toString().matches("2")) {
				vote.vote = 2
				question.answerTwoVotes = question.answerTwoVotes + 1
			}
			
			// Save the question vote
			question.totalVotes = question.totalVotes + 1
			question.save(flush:true)
			
			// save the vote
			vote.save(flush:true)
			
			// Now render new question stats split by a ":"  
			question.totalVotes

			// Calc percent diff
			String percentDif = (calcHighDiffPercent(true,question.totalVotes,question.answerOneVotes,question.answerTwoVotes,0,0)).toString().replace(".", "")
				
			render ("True" + ":" + question.totalVotes + ":" + question.answerOneVotes + ":" + question.answerTwoVotes + ":" + percentDif)
			
			} else {
			// *********** Custom question vote ***********

			}	
			
		} else {
			render ("False")
		}	
		
		} else {
			render ("False")	
		}
		
		
	}
	
	def calcHighDiffPercent (boolean yesNo, totalVotes, int q1, int q2, int q3, int q4) {
		// Returns the highest percentage of the difference 
		if (totalVotes > 0) {
			int diff
			if (yesNo) {
				int q1Per = Math.round((q1 / totalVotes * 100))
				int q2Per = Math.round((q2 / totalVotes * 100))		
				if (q1Per > q2Per) {
					diff = q1Per	
				} else {
					diff = q2Per
				} 
			} else {
			 // Nothing
			}
			return diff
			} else {
			return 0
		}

	}
	
	
	
}

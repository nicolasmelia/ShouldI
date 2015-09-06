package shouldiorv1

import java.util.Date;

class QuestionController {
	
	// This allows us to config database from url
	static scaffold = true
	
	// View of a single question with comments
	def shouldi(String questionID) {
		
		if (questionID != null) {
			params.id = questionID
		}
		
		def question = Question.findByQuestionID(params.id)
		
		// Return a max of 10 comments, offset returns starting at palce 0, sort by votes desc
		def comments = Comment.findAllByQuestionID(params.id, [max: 10, offset: 0, sort: "upVotes", order: "desc"])
		if (question != null) {			
			String percentDif = (calcHighDiffPercent(question)).toString().replace(".", "")
			// Did they vote on this question?
			String vote
			def votes = Vote.findByUserIDAndItemID(session["userID"], question.questionID)
		if (votes !=null) {
			vote = votes.vote + ""	
		} else {
			vote = "NONE"
		}
		
		// add one to the questions views
		question.totalViews = question.totalViews + 1
		question.save(flush:true)
		
		// add one to the OPs view count
		try {
			if (session["UserID"].toString().matches(question.UserID)) {
				User user = User.findByUserID(question.UserID)
				user.peopleReached =  user.peopleReached + 1
			}
		} catch (Exception ex) {
			// Do nothing. User is either deleted or banned. 
		}
		
		// Check is question has an image
		boolean hasQuestionImage = false
		if (question.answerOneImage) {
			hasQuestionImage = true;
		} else if (question.answerTwoImage) {
			hasQuestionImage = true;
		} else if (question.answerThreeImage) {
			hasQuestionImage = true;	
		} else if (question.answerFourImage) {
			hasQuestionImage = true;
		}
		
		String topAnswer = getTopVote(question)
		
		def questions = Question.findAllByTotalVotesGreaterThan(-1)
				
		render(view: "shouldi", model: ["question": question, "questionID": question.questionID, "questionArray" : questions,
			 "percentDiff": percentDif, "vote": vote, "totalViews" : question.totalViews, "hasQuestionImage": hasQuestionImage, "topAnswer": topAnswer])
		
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
		
		question.answerOne = params.answerOne
		question.answerTwo = params.answerOne
		
		if (params.image1 != null) {
			def f = request.getFile('image1')
				question.answerOneImage = f.bytes
		}
	
		question.answerOneVotes = 0
		question.answerTwoVotes = 0
		
		question.totalVotes = 0
		question.totalViews = 0
		question.totalComments = 0
		
		question.UserID = session["userID"]
		
		question.ClientAddress = request.getRemoteAddr().toString()
		question.save(flush:true)
		
		// Render question page for user posting
		shouldi(question.questionID)
		
	}
	
	
	
	// ********************* ASK SHOULD I CUSTOM *********************
	
	def askShouldICustom() {
		if (session["userID"] != null) {
		render(view: "askshouldiCustom")
		} else {
			render "Please log in bitch"
		}
	}
	
	
	def postShouldICutom() {
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
		
		question.custom = true
		question.yesOrNo = false // This is a YES/NO question
		
		if (params.anonymous != null) {
			question.anonymous = params.anonymous
		} else {
			question.anonymous = false
		}
		
		question.question = params.question
		question.questionTitle = params.title
		question.tags = params.tags
		question.date = new Date()
		
		question.answerOne = params.answerOne
		question.answerTwo = params.answerTwo
		
		question.answerOneVotes = 0
		question.answerTwoVotes = 0
		
		if (params.image1 != null) {
			def f = request.getFile('image1')
				question.answerOneImage = f.bytes
		}
		
		
		if (params.image2 != null) {
			def f = request.getFile('image2')
				question.answerTwoImage = f.bytes
		}
		
		
		if (params.answerThree != null) {
			question.answerThree = params.answerThree	
			if (params.image3 != null) {
				def f = request.getFile('image3')
					question.answerThreeImage = f.bytes
			}		
			
			question.answerThreeVotes = 0
		} 
		
		if (params.answerFour != null) {
			question.answerFour = params.answerFour
			if (params.image4 != null) {
				def f = request.getFile('image4')
					question.answerFourImage = f.bytes
			}		
			question.answerFourVotes = 0	
		}
		
		question.totalVotes = 0
		question.totalViews = 0	
		question.totalComments = 0
		
		question.UserID = session["userID"]
		
		question.ClientAddress = request.getRemoteAddr().toString()
		question.save(flush:true, failOnError: true)
		render "Created"
					
	}
	
	// ********************* Get answer image by ID and numset *********************
	def getAnswerImageById() {
		// param is split by question id then number of question using :
		Question question = Question.findByQuestionID(params.id.split(":")[0])
		if (question != null) {
			String imageSetNum = params.id.split(":")[1]
			if (imageSetNum.matches("1")) {
                response.outputStream << question.answerOneImage  // write the photo to the outputstream  
			} else if (imageSetNum.matches("2")) {
				response.outputStream << question.answerTwoImage  // write the photo to the outputstream
			} else if (imageSetNum.matches("3")) {
				response.outputStream << question.answerThreeImage  // write the photo to the outputstream
			} else if (imageSetNum.matches("4")) {
			response.outputStream << question.answerFourImage  // write the photo to the outputstream
			}
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

			// *********** YES/NO question vote ***********
			if (params.vote.toString().matches("1")) {
				vote.vote = 1
				question.answerOneVotes = question.answerOneVotes + 1
			} else if (params.vote.toString().matches("2")) {
				vote.vote = 2
				question.answerTwoVotes = question.answerTwoVotes + 1
			} else if (params.vote.toString().matches("3")) {
				vote.vote = 3
				question.answerThreeVotes = question.answerThreeVotes + 1
			} else if (params.vote.toString().matches("4")) {
				vote.vote = 4
				question.answerFourVotes = question.answerFourVotes + 1
			}
			
			// Save the question vote
			question.totalVotes = question.totalVotes + 1
			question.save(flush:true)
			
			// save the vote
			vote.save(flush:true)

			// Calc percent diff
			String percentDif = (calcHighDiffPercent(question)).toString().replace(".", "")
			
			// Get top asnwer
			String topAnswer = getTopVote(question)
			
			render ("True" + ":" + percentDif + ":" + topAnswer + ":" + question.totalVotes + ":" + question.answerOneVotes + ":" + 
				question.answerTwoVotes + ":" + question.answerThreeVotes + ":" + question.answerFourVotes  + ":")
			
			
		} else {
			// User already voted
			render ("False")
		}	
		
		} else {
			// User does not contain session.
			render ("False")	
		}
		
		
	}
	
	def calcHighDiffPercent (Question question) {
		// Returns the highest percentage of the difference 
		if (question.totalVotes > 0) {
			int diff
			if (question.yesOrNo) {
				int q1Per = Math.round((question.answerOneVotes / question.totalVotes * 100))
				int q2Per = Math.round((question.answerTwoVotes / question.totalVotes * 100))		
				if (q1Per > q2Per) {
					diff = q1Per	
				} else {
					diff = q2Per
				} 
			} else {		
				int q1Per = Math.round((question.answerOneVotes / question.totalVotes * 100))
				int q2Per = Math.round((question.answerTwoVotes / question.totalVotes * 100))
				
				int q3Per
				if (question.answerThreeVotes){	
				q3Per = Math.round((question.answerThreeVotes / question.totalVotes * 100))
				} else {
				q3Per = 0;
				}
						
				int q4Per
				if (question.answerThreeVotes){
				q4Per = Math.round((question.answerFourVotes / question.totalVotes * 100))
				} else {
				q4Per = 0;
				}				
					
				int q1q2diff
				int q3q4diff
				
				if (q1Per > q2Per) {
					q1q2diff = q1Per
				} else {
					q1q2diff = q2Per
				}	
				
				if (q3Per > q4Per) {
					q3q4diff = q3Per
				} else {
					q3q4diff = q4Per
				}
				
				if (q1q2diff > q3q4diff) {	
					diff = q1q2diff
				} else {
					diff = q3q4diff	
				}		
						
			}
			return diff
			} else {
			return 0
		}

	}
	
	def getTopVote(Question question) {
		// get top question
		ArrayList<Integer> voteCounts = new ArrayList<Integer>()
		voteCounts.add(question.answerOneVotes)
		voteCounts.add(question.answerTwoVotes)
		voteCounts.add(question.answerThreeVotes)
		
		voteCounts.add(question.answerFourVotes)
		print  "q three: " + question.answerThree
		String topAnswer
		if (question.yesOrNo) {
			topAnswer = "Yes"
		} else {
			topAnswer = question.answerOne
		}
		int maxValue = voteCounts[0];
		for(int i=1; i < voteCounts.size; i++){
			if(voteCounts[i] > maxValue){
				maxValue = voteCounts[i];
				print maxValue
				switch (i) {
					case 1:  if (question.yesOrNo) {
								topAnswer = "No"
							} else {
								topAnswer = question.answerTwo
							}
							break;
					case 2: topAnswer = question.answerThree
							break;
					case 3: topAnswer = question.answerFour
							break;
				}
			}
	   }
		
		return topAnswer
	}
	
	
	
}

package shouldiorv1

import java.util.Date;

class QuestionController {
	
	// This allows us to config database from url
	static scaffold = true
	
	// View of a single question with comments
	def shouldi(String questionID) {
		
		def question = Question.findByQuestionID(params.id)
		
		if (question != null ) {	
			
			String percentDif = (calcHighDiffPercent(question)).toString().replace(".", "")
			
			String vote = "NONE"
			if (session["userID"] != null)	{	
				// Did they vote on this question?
				def votes = Vote.findByUserIDAndItemID(session["userID"], question.questionID)
				if (votes !=null) {
					vote = votes.vote + ""	
				} 
			} 
		
		// add one to the OPs view count
		User user = User.findByUserID(question.UserID)
		try {
			if (session["userID"].toString().matches(question.UserID)) {
				question.opNotifyVoteCount = 0 // OP has seen new votes set notify count to 0
			} else {
				user.peopleReached =  user.peopleReached + 1
				user.save(flush:true)
			}
		} catch (Exception ex) {
			// Do nothing. User is either deleted or banned. 
		}
		
		question.totalViews = question.totalViews + 1
		question.save(flush:true)
		
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
		
		boolean thisUserPost = false;
		Favorite favorite;
		if (session["userID"] != null) {
			// Check if the viewing user has favorited this question
			 favorite = Favorite.findByUserIDAndQuestionID(session["userID"], question.questionID)
			// Check if this is the viewing users own post
			if (session["userID"].toString().matches(question.userID)) {
				thisUserPost = true		
			}
		}
		
		// gets the top answer for the question
		String topAnswer = getTopVote(question)
		
		def opQuestionCount = Question.countByUserID(question.UserID)
		
	
		
		render(view: "shouldi", model: ["question": question, "questionID": question.questionID, "questionPromo1" : getRandomQuestions(question.category, question.questionID),
			 "thisUserPost": thisUserPost, "percentDiff": percentDif, "vote": vote, "totalViews" : question.totalViews, "hasQuestionImage": hasQuestionImage, "topAnswer": topAnswer,
			 "peopleReached" : user.peopleReached, "opQuestionCount" : opQuestionCount, "notifyCount": getNotifyCount(), "favorite": favorite])
		
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
			// get all categories
			def categories = Category.findAll()
			render(view: "askShouldi", model:[ "notifyCount": getNotifyCount(), "categories" : categories ])
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
		
		print params.anonymous + ": ddd" 
		if (params.anonymous != null) {
			question.anonymous = true
		} else {
			question.anonymous = false
		}
		
		if (params.loginToVote != null) {
			question.requireLoginToVote = true
		} else {
			question.requireLoginToVote = false
		}
		
		question.question = params.question
		question.questionTitle = params.title
		question.category = params.category
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
		question.userName = session["name"]
		
		
		question.ClientAddress = request.getRemoteAddr().toString()
		question.save(flush:true)
		
		
		// Render question page for user posting
		redirect(action: "shouldi", params: [id: question.questionID])
		
	}
	
	
	
	// ********************* ASK SHOULD I CUSTOM *********************
	
	def askShouldICustom() {
		if (session["userID"] != null) {
			// get all categories
			def categories = Category.findAll()
			render(view: "askshouldiCustom", model:[ "notifyCount": getNotifyCount(), "categorie" : categories ])
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
		
		if (params.loginToVote != null) {
			question.requireLoginToVote = true
		} else {
			question.requireLoginToVote = false
		}
		
		
		question.question = params.question
		question.questionTitle = params.title
		question.category = params.category
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
		question.opNotifyVoteCount = 0
		question.userName = session["name"]
		question.UserID = session["userID"]
		
		question.ClientAddress = request.getRemoteAddr().toString()
		question.save(flush:true, failOnError: true)
		render "Created"
					
	}
	
	// ********************* Get answer image by ID and numset *********************
	def getAnswerImageById() {
		// param is split by question id then number of question using :
		Question question = Question.findByQuestionID(params.id)
		if (question != null) {
			String imageSetNum = params.imgNum
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
	

	def addToFavorites() {
		// Adds question to logged in users favorites
		if (session["userID"] != null) {
			User user = User.findByUserID(session["userID"])
			Favorite favoriteExist = Favorite.findByUserIDAndQuestionID(session["userID"], params.questionID)
			if (!favoriteExist) {	
				Favorite favorite = new Favorite();
				favorite.questionID = params.questionID
				favorite.userID = session["userID"]
				favorite.dateAdded = new Date();
				favorite.save(flush:true)
				render ("True")
			} else if (favoriteExist) {
				favoriteExist.delete(flush:true)
				render ("Has")			
			} else {
				render ("False")  // who knows
			}
		} else {
			render ("False") // Not logged in
		} 
	}
	
	def questionVote() {
		if (session["userID"] != null || params.requireLoginToVote.toString().matches("false")) {
		
		// If logged in DO NOT allow two votes
		int voteCount = 0
		if (session["userID"] != null) {
			
			// inc votes the user has made
			User user = User.findByUserID(session["userID"])
			user.totalVotes = user.totalVotes + 1
			user.save(flush:true)
			
			// Get count of votes on this questions.
			voteCount = Vote.countByUserIDAndItemID(session["userID"], params.questionID)
		}
					
		if (voteCount == 0) {
			// Create a vote
			Vote vote = new Vote()
			
			if (session["userID"] != null) {
				vote.userID = session["userID"]
			} else if (params.requireLoginToVote.toString().matches("false")) {
				vote.userID = 'NOT_REQUIRED'
			} else {
				// Umm.. Something went wrong.
				vote.userID = 'NOT_REQUIRED'		
			}
			
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
			//question.opNotifyVoteCount = question.opNotifyVoteCount + 1

			if (session["userID"] != null) {
				if (!session["userID"].toString().matches(question.UserID)) {
					question.opNotifyVoteCount = question.opNotifyVoteCount + 1
				} else if (params.requireLoginToVote.toString().matches("false") && !session["userID"].toString().matches(question.UserID)) {
					question.opNotifyVoteCount = question.opNotifyVoteCount + 1
				}
			} else if (params.requireLoginToVote.toString().matches("false")){
				question.opNotifyVoteCount = question.opNotifyVoteCount + 1
			}

			
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
			render ("False" + ":" + "voted")
		}	
		
		} else {
			// Login required to vote
			render ("False" + ":" + "login")	
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
	
	def getNotifyCount() {
		// get the op notification count
		def notifyCount = "";
		if (session["userID"] != null) {
		 def notifyCountResult =  Question.executeQuery("select COUNT(*) from Question a where a.opNotifyVoteCount > 0 AND a.userID = ?", [session['userID']])
		 notifyCount = notifyCountResult.toString().replaceAll("\\[", "").replaceAll("\\]","");
		}
		return notifyCount
	}
	
	def getRandomQuestions(String category, String questionID) {
		ArrayList<Question> questions = new ArrayList<Question>()
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date date = cal.getTime();
		
		// ******** Half from this category and half from other categories **********
		
		// From this category
		def questionSet1 = Question.executeQuery("FROM Question a WHERE a.category = ? AND date > ? AND a.questionID <> ? ORDER BY RANDOM()", [category, date, questionID], [max: 5])
		
		// Random from other categories
		def questionSet2 = Question.executeQuery("FROM Question a WHERE date > ? AND a.questionID <> ? ORDER BY RANDOM()", [date, questionID], [max: 5])
		
		// List of id's to not allow duplicates
		ArrayList<String> questionIds = new ArrayList<String>()

		for (Question question : questionSet1){
			questionIds.add(question.questionID)
			questions.add(question)
			}
		
		for (Question question : questionSet2) {
			
			boolean allowAdd = true
			
			for (String QuestionID : questionIds) {
				if (question.questionID.matches(QuestionID)) {
					allowAdd = false
				}
			}
			
			if (allowAdd) {
				questionIds.add(question.questionID)
				questions.add(question)
			}			
		}	
		return questions
		}
	
	def nextInCat() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date date = cal.getTime();
		def question = Question.executeQuery("FROM Question a WHERE a.category = ? AND date > ? ORDER BY RANDOM()", [params.category, date], [max: 1])
		redirect(action: "shouldi", params: [id: question[0].questionID])
	}
}

package shouldiorv1

import com.mysql.jdbc.Blob
import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.image.DataBufferByte
import java.util.Date;
import javax.imageio.*
import org.apache.commons.io.IOUtils
import org.imgscalr.*
import org.omg.CORBA.portable.ApplicationException

class QuestionController {
	// This allows us to config database from url
	//static scaffold = true
	
	def index() {
		shouldi()
	}
	
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
			 favorite = Favorite.findByUserIDAndQuestionIDAndFavType(session["userID"], question.questionID, "Question")
			// Check if this is the viewing users own post
			if (session["userID"].toString().matches(question.userID)) {
				thisUserPost = true
			}
		}
		
		// gets the top answer for the question
		String topAnswer = getTopVote(question)
			
		render(view: "shouldi", model: ["question": question, "questionID": question.questionID, "questionPromo1" : getRandomQuestions(question.category, question.questionID),
			 "thisUserPost": thisUserPost, "percentDiff": percentDif, "vote": vote, "totalViews" : question.totalViews, "hasQuestionImage": hasQuestionImage, "topAnswer": topAnswer,
			 "user" : user, "notifyCount": getNotifyCount(), "favorite": favorite])
		
		} else {
			showErrorPage()
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
			showErrorPage()
		}
	}
	
	def postShouldI () {
		Question question = new Question()
		
		// Get the user who is creating this post
		User user = User.findByUserID(session["userID"])
		
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
		
		def f = request.getFile('image1')
		if (f.bytes.length > 0) {
			saveImage(question.questionID, 1, f)
			question.answerOneImage = true	
		}  
		
		question.answerOneVotes = 0
		question.answerTwoVotes = 0
		
		question.totalVotes = 0
		question.totalViews = 0
		question.totalComments = 0
		
		question.UserID = user.userID
		question.userName = user.name
			
		question.ClientAddress = request.getRemoteAddr().toString()
		question.save(flush:true)
		
		// Render question page for user posting
		redirect(action: "shouldi", params: [id: question.questionID])
		
	}
	
	
	
	// ********************* ASK SHOULD I CUSTOM *********************
	
	def askShouldICustom() {
		
		User user = User.findByUserID(session["userID"])
		
		if (session["userID"] != null) {
			// get all categories
			def categories = Category.findAll()
			render(view: "askshouldiCustom", model:[ "notifyCount": getNotifyCount(), "categories" : categories ])
		} else {
			showErrorPage()
		}
	}
	
	
	def postShouldICutom() {
		Question question = new Question()
		
		// Get the user who is creating this post
		User user = User.findByUserID(session["userID"])
		
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
		
		question.custom = true // This is a custom question
		question.yesOrNo = false
		
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
		
		def f1 = request.getFile('image1')
			if (f1.bytes.length > 0) {
				saveImage(question.questionID, 1, f1)
				question.answerOneImage = true
		}
		
		
		def f2 = request.getFile('image2')
			if (f2.bytes.length > 0) {
				saveImage(question.questionID, 2, f2)
				question.answerTwoImage = true
				
		}
	
		
		if (params.answerThree != null) {
			question.answerThree = params.answerThree
			def f3 = request.getFile('image3')
			if (f3.bytes.length > 0) {
				saveImage(question.questionID, 3, f3)
				question.answerThreeImage = true
				
			}
			
			question.answerThreeVotes = 0
		}
		
		if (params.answerFour != null) {
			question.answerFour = params.answerFour
			def f4 = request.getFile('image4')
			if (f4.bytes.length > 0) {
				saveImage(question.questionID, 4, f4)
				question.answerFourImage = true
				
			}
			question.answerFourVotes = 0
		}
		
		question.totalVotes = 0
		question.totalViews = 0
		question.totalComments = 0
		question.opNotifyVoteCount = 0
		question.userName = user.name
		question.UserID = user.userID
		
		question.ClientAddress = request.getRemoteAddr().toString()
		question.save(flush:true, failOnError: true)
		
		// Render question page for user posting
		redirect(action: "shouldi", params: [id: question.questionID])
					
	}
	
	// ********************* Get answer image by ID and numset *********************
	def getAnswerImageById() {
		try {
			if (params.thumb.equals("True")) {
				// get image thumbnail
				response.outputStream << QuestionImage.executeQuery("select imageThumbNail from QuestionImage where questionID = ? and answerNum = ?", [params.id, Integer.parseInt(params.imgNum)]).get(0) 
				response.outputStream.flush()
			} else if (params.thumb.equals("False"))  {
				// get full image 
				response.outputStream << QuestionImage.executeQuery("select image from QuestionImage where questionID = ? and answerNum = ?", [params.id, Integer.parseInt(params.imgNum)]).get(0)
				response.outputStream.flush()
			} else {
				// Return nothing
			}
		}
		catch(Exception ex) {
			// Return nothing			
		}
	} 
	
	def getShareImageById() {
		try {
				// get full image
				response.outputStream << QuestionImage.executeQuery("select image from QuestionImage where questionID = ? and answerNum = ?", [params.id, 1]).get(0)
				response.outputStream.flush()
			}  catch(Exception ex) {
			// Return nothing
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
				favorite.favType = "Question"
				favorite.userID = session["userID"]
				favorite.dateAdded = new Date();
				favorite.save(flush:true)
				render ("Added")
			} else if (favoriteExist) {
				favoriteExist.delete(flush:true)
				render ("Deleted")
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
				addToBattleHash("YES")
			} else if (params.vote.toString().matches("2")) {
				vote.vote = 2
				question.answerTwoVotes = question.answerTwoVotes + 1
				addToBattleHash("NO")
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
				if (question.answerFourVotes){
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
		def questionSet1 = Question.executeQuery("FROM Question a WHERE a.category = ? AND date > ? AND a.questionID <> ? ORDER BY RAND()", [category, date, questionID], [max: 8])
		
		// Random from other categories
		def questionSet2 = Question.executeQuery("FROM Question a WHERE a.category != 'Hot or Not' AND date > ? AND a.questionID <> ? ORDER BY RAND()", [date, questionID], [max: 3])
		
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
		def question = Question.executeQuery("FROM Question a WHERE a.category = ? AND date > ? ORDER BY RAND()", [params.category, date], [max: 1])
		redirect(action: "shouldi", params: [id: question[0].questionID])
	}
	
	def addToBattleHash(String answer){
		try {
			 DataHash dh = DataHash.findByHashID("battleHash");
			 
			 if (dh == null) {
				 dh = new DataHash()
				 dh.hashID = "battleHash"
				 dh.hash = "0"
				 dh.hash2 = "0"
				 dh.save(flush:true)
			 }
			 
			 if (answer.equals("YES")) {
				 int newHashCount = Integer.parseInt(dh.hash) + 1
				 dh.hash = newHashCount + ""
				 dh.save(flush:true)
			 } else {
				 // No
				 int newHashCount = Integer.parseInt(dh.hash2) + 1
				 dh.hash2 = newHashCount + ""
				 dh.save(flush:true)
			 }
		} catch (Exception ex) {
			// Do nothing
		}
	}
	
	def showErrorPage() {
		redirect(controller: "shouldI", action: "thisIsNotGood")
	}
	
	def saveImage(questionID, answerNum, imgFile){
		QuestionImage image = new QuestionImage()
		image.questionID = questionID
		image.answerNum = answerNum
		String fileExt = imgFile.originalFilename.toString().substring(imgFile.originalFilename.lastIndexOf(".") + 1).replace(".", "");
		// ************ Save full size image ************
		// Get length of file in bytes
		long fileSizeInBytes = imgFile.bytes.length / 1024;
		if (fileSizeInBytes > 1500 && !fileExt.matches("gif") && !fileExt.matches("Gif")) { // if file size is over 1.5mb compress the image
			ByteArrayInputStream bais1 = new ByteArrayInputStream(imgFile.bytes);
			BufferedImage orginalImage1 = ImageIO.read(bais1)
			
			BufferedImage compresedImg =
				Scalr.resize(orginalImage1, Scalr.Method.QUALITY, Scalr.Mode.FIT_TO_WIDTH,
				900, 900, Scalr.OP_ANTIALIAS);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(compresedImg, fileExt, baos);
			byte[] compresedImgBytes = baos.toByteArray();
			image.image = compresedImgBytes		
		} else {
			image.image = imgFile.bytes
		}
					
		// ************ Create the thumbnail ************
		ByteArrayInputStream bais = new ByteArrayInputStream(imgFile.bytes);
		BufferedImage orginalImage = ImageIO.read(bais)
		
		BufferedImage thumbnail =
			Scalr.resize(orginalImage, Scalr.Method.BALANCED, Scalr.Mode.FIT_TO_WIDTH,
			200, 200, Scalr.OP_ANTIALIAS);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(thumbnail, fileExt, baos);
		byte[] thumbNailBytes = baos.toByteArray();		 
		image.imageThumbNail = thumbNailBytes

		// ************ Save the image to the DB ************
		image.save(flush:true)		
	}

	
	
} 

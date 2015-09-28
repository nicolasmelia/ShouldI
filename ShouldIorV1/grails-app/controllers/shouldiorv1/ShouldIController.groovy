package shouldiorv1

class ShouldIController {

    def index() {	
		renderHome()	
	}
	
	def home() {
		renderHome()
	}
	
	def renderHome() {	
		// Get counts for the pie chart
		int yesCount = Vote.countByVote("1")
		int noCount = Vote.countByVote("2")
		
		// get message of the day from hash
		DataHash motd = DataHash.findByHashID("motd")
		
		render (view: "home", model: ["yesCount" : yesCount, "noCount" : noCount, "trendingQuestions": getPopularQuestions(), 
			"randomQuestions": getRandomQuestions(), "notifyCount": getNotifyCount(),
			 "messageTitle" : motd.hash, "messageText" : motd.hash2])	
	}
	
	def editMotd() {		
		render(view:"editMotd")
	}
	
	def updateMotd() {
		DataHash motd = DataHash.findByHashID("motd")
		if (motd) {
			motd.hash = params.title
			motd.hash2 = params.text
			motd.save(flush:true)
			render(view:"home")
		} else {
			DataHash newMotd = new DataHash()
			newMotd.hashID = "motd"
			newMotd.hash = params.title
			newMotd.hash2 = params.text
			newMotd.save(flush:true)
			render(view:"home")	
		}
	}
	
	
	def category() {
		// ********* Category Page ********* 
		// Configure off pagination
		if (params.category == null) {
			params.category = "Trending"
		}
		
		int offset
		if (params.offset == null) {
			offset = 0
		} else {
			offset = Integer.parseInt(params.offset);
		}
		
		if (params.up.toString().matches("true")) {
			offset = offset + 10
		} else if (params.up.toString().matches("false"))  {
		if (offset != 0) { // Dont allow offset to go below 0
			offset = offset - 10
		}
		} else if (params.up.toString().matches("reset"))  {
			offset = 0
		}
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date date = cal.getTime();
		
		def questions
		if (params.category.toString().equals("Trending")){
			questions = Question.executeQuery("FROM Question a WHERE date > ? ORDER BY totalVotes DESC", [date], [max: 10, offset: offset])	
		} else  if (params.category.toString().equals("Recent")){
			questions = Question.executeQuery("FROM Question a WHERE date > ? ORDER BY date DESC", [date], [max: 10, offset: offset])
		} else {
			// All other categories 
			 questions = Question.executeQuery("FROM Question a WHERE date > ? AND category = ? ORDER BY date DESC", [date, params.category], [max: 10, offset: offset])
		}
		
		// Query for questions
		render (view: "category", model: ["questions": questions, "offset" : offset, "category" : params.category, "notifyCount": getNotifyCount()])		
	}
	
	def help() {
		def question = Question.findAllByTotalVotesGreaterThan(-1)
		render (view: "category", model: ["question": question, "notifyCount": getNotifyCount()])
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
	
	def getPopularQuestions() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date date = cal.getTime();
		def questions = Question.executeQuery("FROM Question a WHERE totalVotes > 0 AND date > ? ORDER BY totalVotes DESC", [date], [max: 15])
		return questions
	}
	
	def getRandomQuestions() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date date = cal.getTime();
		def questions = Question.executeQuery("FROM Question a WHERE date > ? ORDER BY RANDOM()", [date], [max: 15])
		return questions	
	}
	
	
}

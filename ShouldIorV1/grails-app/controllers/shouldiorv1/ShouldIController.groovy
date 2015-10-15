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
		DataHash dh = DataHash.findByHashID("battleHash");
		String yesCount = "0"
		String noCount = "0"
		if (dh != null){
		 yesCount = dh.hash
		 noCount = dh.hash2
		} 
		
		// get message of the day from hash
		DataHash motd = DataHash.findByHashID("motd")
		if (motd == null)  {
			motd = new DataHash()
			motd.hash = ""
			motd.hash2 = ""
		}
		
		def popQuestions = getPopularQuestions()
		
		render (view: "home", model: ["yesCount" : yesCount, "noCount" : noCount, "popularQuestions": popQuestions, 
			 "notifyCount": getNotifyCount(),
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
		
		String categorySort = "None"
		def questions
		if (params.category.toString().equals("Trending")){
			questions = Question.executeQuery("FROM Question a WHERE a.category != 'Hot or Not' AND date > ? ORDER BY totalVotes DESC", [date], [max: 10, offset: offset])	
		} else  if (params.category.toString().equals("Recent")){
			questions = Question.executeQuery("FROM Question a WHERE a.category != 'Hot or Not' ORDER BY date DESC", [max: 10, offset: offset])
		} else {
			
			// get the category sort method
			if (params.categorySort == null) {
				categorySort = "Trending"
			} else {
				categorySort = params.categorySort
			}
			
			if (categorySort.equals("Trending")) {
				questions = Question.executeQuery("FROM Question a WHERE a.date > ? AND a.category = ? ORDER BY totalVotes DESC", [date, params.category], [max: 10, offset: offset])
			} else if (categorySort.equals("Recent")) {
				// All other categories 
				 questions = Question.executeQuery("FROM Question a WHERE a.category = ? ORDER BY date DESC", [params.category], [max: 10, offset: offset])
			} else {
			// Not sure what went wrong... No category is set, load trending.
				questions = Question.executeQuery("FROM Question a WHERE a.category != 'Hot or Not' AND a.date > ? AND a.category = ? ORDER BY totalVotes DESC", [date, params.category], [max: 10, offset: offset])
			} 
			
		}
		
		// get all categories 
		def categories = Category.findAll()
		
		// Query for questions
		render (view: "category", model: ["questions": questions, "offset" : offset, "category" : params.category, "notifyCount": getNotifyCount(), "categories" : categories, "categorySort" : categorySort])		
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
		def questions = Question.executeQuery("FROM Question a WHERE a.date > ? AND a.category != 'Hot or Not' ORDER BY  a.totalVotes", [date], [max: 25])
		// def questions = Question.executeQuery("FROM Question a WHERE a.totalVotes > 100 AND a.date > ?  AND a.category != 'Hot or Not' ORDER BY RAND()", [date], [max: 25])	
		return questions
	}
	
	def getRandomQuestions() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date date = cal.getTime();
		def questions2 = Question.executeQuery("FROM Question a WHERE a.category != 'Hot or Not' AND date > ? ORDER BY RAND()", [date], [max: 9])
		return questions2
	}
	 
	def thisIsNotGood() {
		render (view:"errorPage404")
	}
	
	def help() {
		render (view: "help", model: ["notifyCount": getNotifyCount()])
	}
	
	def privacyPolicy() {
		render (view: "privacyPolicy", model: ["notifyCount": getNotifyCount()])	
	}
	
	def aboutPollaris() {
		render (view: "pollarisPolls", model: ["notifyCount": getNotifyCount()])
	}
	
	
}

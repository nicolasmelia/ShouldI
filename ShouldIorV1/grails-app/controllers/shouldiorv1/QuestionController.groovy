package shouldiorv1

class QuestionController {

    def index() { 
		render("You do not have permission to view this page")
	}
	
	// View of a single question with comments
	def shouldi() {
		def question = Question.findByQuestionID(params.id)
		// Return a max of 10 comments, offset returns starting at palce 0, sort by votes desc
		def comments = Comment.findAllByQuestionID(params.id, [max: 10, offset: 0, sort: "upVotes", order: "desc"])
		render(view: "shouldi", model: ["question": question, "comments": comments])		
	}
	
	
	
	
	
}

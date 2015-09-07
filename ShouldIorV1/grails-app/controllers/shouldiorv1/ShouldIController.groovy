package shouldiorv1

class ShouldIController {

    def index() {	
		def question = Question.findAllByTotalVotesGreaterThan(-1)
		render (view: "home", model: ["question": question])
	}
	
	def home() {
		def question = Question.findAllByTotalVotesGreaterThan(-1)
		render (view: "home", model: ["question": question])
	}
}

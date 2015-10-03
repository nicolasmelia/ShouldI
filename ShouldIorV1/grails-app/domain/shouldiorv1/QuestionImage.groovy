package shouldiorv1

class QuestionImage {
	
	String questionID // Question this comment belongs to
	int answerNum // answer this belongs too 1-4
	byte[] image
	byte[] imageThumbNail
	
	
    static constraints = {
		image(nullable:true, maxSize: 1024 * 1024 * 3 /* 2MB */)
		imageThumbNail(nullable:true, maxSize: 1024 * 1024 * 3 /* 2MB */)
    }
}

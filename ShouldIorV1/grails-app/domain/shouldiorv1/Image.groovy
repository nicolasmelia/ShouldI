package shouldiorv1

class Image {
	
	String questionID // Question this comment belongs to
	int answerNum // answer this belongs too 1-4
	byte[] image
	
    static constraints = {
		image(nullable:true, maxSize: 1024 * 1024 * 3 /* 2MB */)
    }
}

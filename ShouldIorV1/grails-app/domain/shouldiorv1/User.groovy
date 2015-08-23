package shouldiorv1

class User {
	
	String accountType // Either shouldI, facebook or twitter
	String token // This can be used for social network auth, ie. access_token from FB
	String userID
	byte[] avatar
	
	
	String name
	String userName
	String password
	
	int peopleReached

    static constraints = {
		userName nullable: true
		avatar nullable: true	
		token(maxSize: 5000)	
    }
}

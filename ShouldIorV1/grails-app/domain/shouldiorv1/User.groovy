package shouldiorv1

class User {
	
	String accountType // Either shouldI, facebook or twitter
	String token // This can be used for social network auth, ie. access_token from FB
	String userID
	
	String name
	String userName
	String password
	
	int peopleReached

    static constraints = {

    }
}

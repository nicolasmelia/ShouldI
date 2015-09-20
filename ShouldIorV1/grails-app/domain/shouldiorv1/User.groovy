package shouldiorv1

class User {
	
	String accountType // Either shouldI, facebook or twitter
	String token // This can be used for social network auth, ie. access_token from FB
	String userID
	byte[] avatar
	String about // bio or whatever
	Date dateCreated
	
	String name
	String userName
	String password
	
	int peopleReached
	int totalVotes
	
	
    static constraints = {
		userName nullable: true
		avatar nullable: true	
		about nullable:true
		
		about maxSize: 20000
		
		token maxSize: 5000	
    }
}

package shouldiorv1

class User {
	
	String accountType // Either shouldI, facebook or twitter
	String token // This can be used for social network auth, ie. access_token from FB
	String userID
	byte[] avatar
	String about // bio or whatever
	Date dateCreated
	
	String name // Username
	
	String loginName
	String password
	String favorites
	
	int peopleReached
	int totalVotes
	int totalQuestions
	int followerCount
	
	boolean certified
	boolean deleted
	
    static constraints = {
		name nullable: true
		followerCount nullable:true
		
		avatar(nullable:true, maxSize: 1024 * 1024 * 2 /* 2MB */)
	
		about nullable:true
		
		deleted nullable:true
		certified nullable: true
		
		about maxSize: 20000
		favorites nullable: true
		
		token maxSize: 5000	
    }
}

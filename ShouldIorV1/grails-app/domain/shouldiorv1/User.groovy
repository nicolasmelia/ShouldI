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
	String favorites
	
	int peopleReached
	int totalVotes
	int followerCount
	
	boolean certified
	boolean deleted
	
    static constraints = {
		userName nullable: true
		followerCount nullable:true
		
		avatar nullable: true	
		about nullable:true
		
		deleted nullable:true
		certified nullable: true
		
		about maxSize: 20000
		favorites nullable: true
		
		token maxSize: 5000	
    }
}

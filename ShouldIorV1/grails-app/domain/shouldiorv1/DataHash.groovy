package shouldiorv1

class DataHash {
	
	String HashID
	String hash
	String hash2

    static constraints = {
		hash(nullable:true)
		hash2(nullable:true)	
    }
}

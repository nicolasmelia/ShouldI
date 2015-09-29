package shouldiorv1

class Category {
	
	String category
	String categoryAlias
	
    static constraints = {
		categoryAlias(nullable:true)
    }
	
}

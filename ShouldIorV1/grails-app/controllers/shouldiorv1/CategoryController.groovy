package shouldiorv1

class CategoryController {

	static scaffold = true
	
	def addCategory() {
		render(view:"addCategory")	
	}
	
	def createCategory() {
		Category category = new Category()
		
		category.category = params.category
		
		if (params.categoryAlias != null) {
			category.categoryAlias = params.categoryAlias
		}
		
		category.save(flush:true)
		render(view:"addCategory")	

	}
	
	
}

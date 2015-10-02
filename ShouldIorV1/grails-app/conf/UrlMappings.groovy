class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "shouldI", action: "home")
        "500"(controller: "shouldI", action: "thisIsNotGood")
	}
}

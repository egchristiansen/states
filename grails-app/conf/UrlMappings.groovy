class UrlMappings {

	static mappings = {
		"/state/index" {
    		controller = "state"
    		action = "tagcloud"
		}
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}

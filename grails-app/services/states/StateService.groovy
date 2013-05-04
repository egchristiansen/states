package states

import groovyx.net.http.*
import static groovyx.net.http.ContentType.*

class StateService {

	static mappings = {
   		"/state/$id?"(resource:"state")
	}

    def callWebService() {
    	println "here"
    	println ContentType.TEXT
    	def response
    	withRest(id: "zipcodes", uri: "http://gomashup.com") {
	        response = get(
	       		path: "/json.php",
	       		contentType : ContentType.TEXT,
	       		query : [fds:'fds=geo/usa/zipcode/state/IL']
	       	)

	    }

	    println "Made it!"

    }

    def getZipCountsByState(List states) {
    	def zipCounts = [:]
    	def stateName = ''
    	def locationCount = 0

    	//Should probably go back 
    	states = states.sort {State a, State b -> a.toString().compareTo(b.toString()) }

    	for ( state in states ) {
    		stateName = state.toString()
    		locationCount = state.locationCount()
    		zipCounts.put(stateName, locationCount)
		}

		return zipCounts
    }

}

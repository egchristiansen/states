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
    	withHttp(id: "zipcodes", uri: "http://gomashup.com") {
	        response = get(
	       		path: "/json.php",
	       		contentType : ContentType.TEXT,
	       		query : [fds:'geo/usa/zipcode/state/IL']
	       	)

	    }

	    def text = response.getText()
	    if (text.getAt(0) == '(') {
	    	text.replace()
	    }
	    println text.size()
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

    /**
     * That webservice likes to put parenthesis around our JSON object.
     * TODO: Better API?
     */
    def cleanUpJSONResponse (String responseText) {
    	if (responseText.startsWith('(') && responseText.endsWith(')')) {
    		responseText = responseText.substring(1, responseText.length()-1) 
    	}
    	return responseText
    }

}

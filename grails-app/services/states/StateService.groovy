package states

import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import net.sf.*;
import net.sf.json.*;
import net.sf.json.groovy.*;

class StateService {

	static mappings = {
   		"/state/$id?"(resource:"state")
	}

    def callWebService(abbreviation) {
    	def response
    	def fields = 'geo/usa/zipcode/state/' + abbreviation 
    	withHttp(id: "zipcodes", uri: "http://gomashup.com") {
	        response = get(
	       		path: "/json.php",
	       		contentType : ContentType.TEXT,
	       		query : [fds: fields, jsoncallback:'']
	       	)

	    }
        println "Webservice call complete"
	    def text = cleanUpJSONResponse(response.getText())
        println "Cleaning up JSON complete"
	    def stateLocationJSON = new JsonSlurper().parseText(text)
        println "Parse JSON complete"
	    def locations = stateLocationJSON.result
	    return locations

    }

    def getZipCountsByState(List states) {
    	def zipCounts = [:]
    	def stateName = ''
    	def locationCount = 0

    	states = states.sort {State a, State b -> a.toString().compareTo(b.toString()) }

    	for ( state in states ) {
    		stateName = state.toString()
    		locationCount = state.getZipCount()
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

    def createStates () {
        println "Create States Being Called"
    	StateEnum.each {
       		def state = new State()
    		state.name = it.getName()
    		state.abbreviation = it.abbreviation
    		state.zipCount = 0
    		println state.name
    		def locations = callWebService(it.abbreviation)
            println "All webservice work complete"
            state.zipCount = locations.size()
            println "Getting Zip count"
    		
			if (!state.save(failOnError: true)) {
				println "Failed on " + state.name + " " + state.abbreviation + " " + state.locations.size()
			}
    		println "After Save state"
    	}
        println "done"

    }

}

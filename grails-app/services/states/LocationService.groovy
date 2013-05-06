package states

import java.util.regex.Pattern;

class LocationService {

    def createLocationsFromJSON(locationsJSON) {
    	def returnList = []
    	def locationArray = locationsJSON.result
    	for (location in locationArray) {
    		returnList.add(location.ZipCode)
    	}

    	return returnList
    }
}

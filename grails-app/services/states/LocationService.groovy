package states

import java.util.regex.Pattern;

class LocationService {

    def createLocationFromJSON(locationJSON) {

    	def location = new Location()
    	
    	location.zipCode = locationJSON.Zipcode
    	location.city = locationJSON.City
    	location.county = locationJSON.County 
    	/*def latitude = locationJSON.Latitude
    	if (latitude != null && latitude.trim() != '') {
    		if (latitude.startsWith('+'))
    			latitude = latitude.replaceFirst(Pattern.quote("+"), '')
            location.latitude = latitude
    	} 

    	def longitude = locationJSON.Longitude
    	if (longitude != null && latitude.trim() != '') {
    		if (longitude.startsWith('+'))
    			longitude = longitude.replaceFirst(Pattern.quote("+"), '')
    	   location.longitude = longitude
        } */
    	//println "loc zip:" + location.zipCode
        
        try {
    	   if(!location.save(flush:true)){
                println "Failed to save location:" + location.city
           }
    	} catch (Exception e) {
            println "Failed to save location" + location.city + " exception"
        }
        return location
    }

    def createLocationsFromJSON(locationsJSON) {
    	def returnList = []
    	def locationArray = locationsJSON.result
    	def locationObj
    	for (location in locationArray) {
    		locationObj = createLocationFromJSON(location)
    		if (locationObj != null) 
    			returnList.add(locationObj)
    	}

    	return returnList
    }
}

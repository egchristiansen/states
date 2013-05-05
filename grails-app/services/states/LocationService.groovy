package states

class LocationService {

    def createLocationFromJSON(locationJSON) {

    	def location = new Location()
    	
    	location.zipCode = locationJSON.Zipcode
    	location.city = locationJSON.City
    	location.county = locationJSON.County 
    	
    	if (locationJSON.Latitude != null)
    		location.latitude = new BigDecimal(locationJSON.Latitude)
    	
    	if (locationJSON.Longitude != null)
    		location.longitude = new BigDecimal(locationJSON.Longitude)
    	
    	return location
    }
}

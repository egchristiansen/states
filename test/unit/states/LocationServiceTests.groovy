package states



import grails.test.mixin.*
import org.junit.*
import net.sf.*;
import net.sf.json.*;
import net.sf.json.groovy.*;
import groovy.json.JsonSlurper


/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LocationService)
class LocationServiceTests {

    void testCreateLocationFromJSON() {
        def locationService = new LocationService()
        def text = '{ result: [{Zipcode: "60001"}]}'
        println text
        def stateLocationJSON = new JsonSlurper().parseText( '{ "Zipcode": "60001", "Longitude": "14.3456" }' )
        
        def expected = new Location()
        expected.zipCode = "60001"

        def location = locationService.createLocationFromJSON(stateLocationJSON);

        assert location != null
        assert location.zipCode == "60001"

    }

    //Test creation of multiple locations
    void testCreateLocationsFromJSON() {
    	def locationService = new LocationService()
        def text = '{ result: [{Zipcode: "60001"}]}'
        println text
        def stateLocationJSON = new JsonSlurper().parseText( '{ "result": [{ "Zipcode": "60001", "Longitude": "+14.3456" }, {"City": "EmilyTopia", "County": "Dakota", "Zipcode": "55306"}]}' )

        def location1 = new Location()
        location1.zipCode = "60001"
        location1.longitude = new BigDecimal("14.3456")

        def location2 = new Location()
        location2.zipCode = "55306" 
        location2.county = "Dakota"
        location2.city = "EmilyTopia"

        def expected = [location1, location2]
		def result = locationService.createLocationsFromJSON(stateLocationJSON)

		assert result.size() == 2
		
		def resultLoc1 = result[0]
		assert resultLoc1 instanceof Location
		assert resultLoc1.zipCode == "60001"
		assert resultLoc1.longitude == new BigDecimal("14.3456")

		def resultLoc2 = result[1]
		assert resultLoc2 instanceof Location
		assert resultLoc2.zipCode == "55306"
		assert resultLoc2.county == "Dakota"
		assert resultLoc2.city == "EmilyTopia"

    }
}

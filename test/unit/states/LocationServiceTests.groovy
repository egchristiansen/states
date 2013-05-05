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
}

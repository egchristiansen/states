package states



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */

@TestFor(StateService)
class StateServiceTests {

    void testGetZipCountsByState() {
        StateService service = new StateService()

        //Let's make some Locations and States for testing
        State minnesota = new State("Minnesota", 3)

        State kentucky = new State("Kentucky", 2)

        State wisconsin = new State("Wisconsin", 1)

        def expected = ["Kentucky" : 2, "Minnesota" : 3, "Wisconsin" : 1]

       	//Make sure it's ordered properly, and has correct data
       	def zipCounts
        zipCounts = service.getZipCountsByState([minnesota, wisconsin, kentucky])

        //Make sure counts are correct
        assert zipCounts["Wisconsin"] == 1
        assert zipCounts["Kentucky"] == 2
        assert zipCounts["Minnesota"] == 3

        //Make sure it's sorted
        assert zipCounts.findIndexOf{it.key=="Kentucky"} == 0
        assert zipCounts.findIndexOf{it.key=="Minnesota"} == 1
        assert zipCounts.findIndexOf{it.key=="Wisconsin"} == 2

    }

    void testCleanUpJSONResponse() {
    	StateService service = new StateService()
    	def jsonResponse = "({result: [{Zipcode: \"60001\"}]})"

    	def expected = "{result: [{Zipcode: \"60001\"}]}"

    	jsonResponse = service.cleanUpJSONResponse(jsonResponse);
    	assert jsonResponse == expected

    }

    void testCleanUpJSONResponseNoParens() {
    	StateService service = new StateService()
    	def jsonResponse = "{result: [{Zipcode: \"60001\"}]}"

    	def expected = "{result: [{Zipcode: \"60001\"}]}"

    	jsonResponse = service.cleanUpJSONResponse(jsonResponse);
    	assert jsonResponse == expected

    }
}

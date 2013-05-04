package states



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(State)
class StateTests {

    void testLocationCount() {
       State testState = new State()
       testState.name = "Minnesota"
       testState.locations = ["55306", "55044"];

       assert 2 == testState.locationCount()

    }
}

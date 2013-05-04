package states



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(TagCloudService)
class TagCloudServiceTests {

    void testGetStateTagSizes() {
        def stateCounts = ["Alaska" : 20,"California" : 900, "Kentucky" : 200, "Minnesota" : 600, "Wisconsin" : 450]
        def expected = ["Alaska" : 1, "California" : 32, "Kentucky": 7, "Minnesota" : 21, "Wisconsin" : 16]
        def stateTagSize = [:]
        def maxTagSize = 32
    	def maxCount = 900
    	def minCount = 20
    	def difference = maxCount - minCount

        TagCloudService tagCloudService = new TagCloudService()

        stateTagSize = tagCloudService.getStateTagSize(stateCounts, maxTagSize)

        assert stateTagSize.size() == 5
        assert stateTagSize["Alaska"] == 1
        assert stateTagSize["California"] == maxTagSize
        assert stateTagSize["Kentucky"] == 6
        assert stateTagSize["Minnesota"] == 21
        assert stateTagSize["Wisconsin"] == 15

    }
}

package states

class TagCloudService {

    def getStateTagSize(Map stateZipCounts, Integer maxTagSize) {
    	def tagSizes = [:]
    	def max = stateZipCounts.max{ it.value }.value
    	def min = stateZipCounts.min{ it.value }.value
    	def spread = max - min
    	def diff 
    	def tagSize

    	for (count in stateZipCounts) {
    		if (count.value == min) 
    			tagSizes[count.key] = 1
    		else {
    			diff = count.value - min
  				tagSize = (maxTagSize * diff) / spread 
  				if(tagSize instanceof BigDecimal)
  					tagSize = tagSize.intValue();
    			tagSizes[count.key] = tagSize
    			
    		}
    	}

    	return tagSizes
    }

}

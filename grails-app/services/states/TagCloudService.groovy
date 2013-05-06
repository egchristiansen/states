package states

class TagCloudService {

    def getStateTagSize(Map stateZipCounts, Integer maxTagSize, Integer minTagSize) {
    	def tagSizes = [:]
    	def max = stateZipCounts.max{ it.value }.value
    	def min = stateZipCounts.min{ it.value }.value
    	def spread = max - min
    	def diff 
    	def tagSize
        def step = (maxTagSize - minTagSize) / spread

    	for (count in stateZipCounts) {
    		if (count.value == min) 
    			tagSizes[count.key] = minTagSize
    		else {
    			diff = count.value - min
                tagSize = (count.value * step) + minTagSize
  				if(tagSize instanceof BigDecimal)
  					tagSize = tagSize.intValue();
    			tagSizes[count.key] = tagSize
    			
    		}
    	}

    	return tagSizes
    }

}

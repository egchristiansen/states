package states

class State {

	String name
	String abbreviation
	Integer zipCount

	String toString() { name }

	Integer getZipCount() { zipCount }

	State() {} 

	//This is here to make my unit tests cleaner
    State(String name, Integer zipCount) { 
    	this.name = name 
    	this.zipCount = zipCount
    } 
    
    static constraints = {
    
    }
}

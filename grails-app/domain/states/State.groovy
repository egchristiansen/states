package states

class State {

	String name
	String abbreviation
	List locations

	String toString () { name }

	Integer locationCount() { locations.size() }

    static constraints = {

    }
}

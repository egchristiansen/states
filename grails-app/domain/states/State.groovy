package states

class State {

	String name
	String abbreviation
	List locations

	static hasMany = [locations: Location]

	String toString () { name }

	Integer locationCount() { locations.size() }

    static constraints = {

    }
}

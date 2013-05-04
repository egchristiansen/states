package states

class State {

	String name
	String abbreviation

	String toString () { name }

	Integer locationCount() { locations.size() }

	static hasMany = [locations: Location]

    static constraints = {

    }
}

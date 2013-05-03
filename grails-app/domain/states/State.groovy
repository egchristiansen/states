package states

class State {

	String name
	String abbreviation
	static hasMany = [locations: Location]

    static constraints = {

    }
}

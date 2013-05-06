package states

public enum StateEnum {
	ALABAMA("Alabama","AL"),
	ALASKA("Alaska","AK"),
	ARIZONA("Arizona","AZ"),
	ARKANSAS("Arkansas","AR"),
	CALIFORNIA("California","CA"),
	COLORADO("Colorado","CO"),
	CONNECTICUT("Connecticut", "CT"),
	DELAWARE("Delaware", "DE"),
	FLORIDA("Florida","FL"),
	GEORGIA("Georgia","GA"),
	HAWAII("Hawaii","HI"),
	IDAHO("Idaho","ID"),
	ILLINOIS("Illinois", "IL"),
	INDIANA("Indiana","IN"),
	IOWA("Iowa","IA"),
	KANSAS("Kansas","KS"),
	KENTUCKY("Kentucky","KY"),
	LOUISIANA("Louisiana","LA"),
	MAINE("Maine","ME"),
	MARYLAND("Maryland","MD"),
	MASSACHUSETTS("Massachusetts","MA"),
	MICHIGAN("Michigan","MI"),
	MINNESOTA("Minnesota","MN"),
	MISSISSIPPI("Mississippi","MS"),
	MISSOURI("Missouri","MO"),
	MONTANA("Montana","MT"),
	NEBRASKA("Nebraska","NE"),
	NEVADA("Nevada","NV"),
	NEWHAMPSHIRE("New Hampshire","NH"),
	NEWJERSEY("New Jersey","NJ"),
	NEWMEXICO("New Mexico","NM"),
	NEWYORK("New York","NY"),
	NORTHCAROLINA("North Carolina", "NC"),
	NORTHDAKOTA("North Dakota","ND"),
	OHIO("Ohio","OH"),
	OKLAMHOMA("Oklahoma","OK"),
	OREGON("Oregon","OR"),
	PENNSYLVANIA("Pennsylvania","PA"),
	RHODEISLAND("Rhode Island","RI"),
	SOUTHCAROLINA("South Carolina","SC"),
	SOUTHDAKOTA("South Dakota","SD"),
	TENNESSEE("Tennessee","TN"),
	TEXAS("Texas","TX"),
	UTAH("Utah","UT"),
	VERMONT("Vermont","VT"),
	VIRGINIA("Virginia","VA"),
	WASHINGTON("Washington","WA"),
	WESTVIRGINIA("West Virginia","WV"),
	WISCONSIN("Wisconsin","WI"),
	WYOMING("Wyoming","WY")

	private final String name
	private final String abbreviation
    StateEnum(String name, String abbreviation) {
    	this.name = name
        this.abbreviation = abbreviation
    }
    private String getName() { return name }
    private String abbreviation() { return abbreviation }
}
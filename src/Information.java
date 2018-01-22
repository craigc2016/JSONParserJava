
public class Information {//start class
	private String synopsis;
	private String hotelName;
	private String restaurants;
	private String places;
	private String things;
	private String name;
	private String description;
	private String location;
	
	public Information(String hotelName,String restaurants,String places,String things){
		this.hotelName = hotelName;
		this.restaurants = restaurants;
		this.places = places;
		this.things = things;
	}
	
	public Information(String synopsis){
		this.synopsis = synopsis;
	}
	
	public Information(String name,String description,String location){
		this.name = name;
		this.description = description;
		this.location = location;
	}
	
	public String getHotelName() {
		return hotelName;
	}

	public String getRestaurant() {
		return restaurants;
	}

	public String getPlace() {
		return places;
	}

	public String getThing() {
		return things;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}
	
	
	public String getSynop(){
		return synopsis;
	}

}//end class

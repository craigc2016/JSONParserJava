
public abstract class County {//start class
	
	public abstract Information getHotels();
	public abstract Information getRestaurants();
	public abstract Information getPlacesOfInterests();
	public abstract Information getThingsToDo();
	public abstract Information getNames();
	public abstract Information getDescriptions();
	public abstract Information getLocations();
	public abstract void getInfo();
	public abstract void setDetailHotel(int index);
	public abstract void setDetailR(int index);
	public abstract void setDetailP(int index);
	public abstract void setDetailT(int index);
	public abstract Information getSynopsis();

}//end class

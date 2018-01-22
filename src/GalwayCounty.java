


import java.io.FileReader;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GalwayCounty extends County {
	private String h,r,p,t,n,d,l,s;
	
	/*
	 * Create a new Information object using a parameter of a getter method
	 * (non-Javadoc)
	 * @see County#getSynopsis()
	 */
	public Information getSynopsis() {
		return new Information(getS());
	}
	
	/*
	 *  Create a new Information object using a parameter of a getter methods
	 * (non-Javadoc)
	 * @see County#getHotels()
	 */
	public Information getHotels() {
		getInfo();
		return new Information(getH(),getR(),getP(),getT());
	}

	/*
	 *  Create a new Information object using a parameter of a getter methods
	 * (non-Javadoc)
	 * @see County#getRestaurants()
	 */
	public Information getRestaurants(){
		getInfo();
		return new Information(getH(),getR(),getP(),getT());
	}

	/*
	 *  Create a new Information object using a parameter of a getter methods
	 * (non-Javadoc)
	 * @see County#getPlacesOfInterests()
	 */
	public Information getPlacesOfInterests() {
		getInfo();
		return new Information(getH(),getR(),getP(),getT());
	}

	/*
	 *  Create a new Information object using a parameter of a getter method
	 * (non-Javadoc)
	 * @see County#getThingsToDo()
	 */
	public Information getThingsToDo() {
		getInfo();
		return new Information(getH(),getR(),getP(),getT());
	}

	/*
	 *  Create a new Information object using a parameter of a getter method
	 * (non-Javadoc)
	 * @see County#getNames()
	 */
	public Information getNames() {
		return new Information(getN(),getD(),getL());
	}

	/*
	 *  Create a new Information object using a parameter of a getter method
	 * (non-Javadoc)
	 * @see County#getDescriptions()
	 */
	public Information getDescriptions() {
		return new Information(getN(),getD(),getL());
	}

	/*
	 *  Create a new Information object using a parameter of a getter method
	 * (non-Javadoc)
	 * @see County#getLocations()
	 */
	public Information getLocations() {
		return new Information(getN(),getD(),getL());
	}
	
	/*
	 * Method to get the hotels
	 */
	public String getH() {
		return h;
	}
	
	/*
	 *  Method to get the restaurants from the getInfo method
	 */
	public String getR() {
		return r;
	}
	/*
	 * Method to get the places from the getInfo method
	 */
	public String getP() {
		return p;
	}
	/*
	 * Method to get the things from the getInfo method
	 */
	public String getT() {
		return t;
	}
	/*
	 * Method to get the name from the getInfo method
	 */
	public String getN() {
		return n;
	}
	/*
	 * Method to get the destination from the getInfo method
	 */
	public String getD() {
		return d;
	}
	/*
	 * Method to get the location from the getInfo method
	 */
	public String getL() {
		return l;
	}
	
	/*
	 * Method to get the Synopsis from the getInfo method
	 */
	public String getS(){
		return s;
	}
	
	/*
	 * Method to set the name variable
	 */
	public void setN(String name) {
		n = name;
	}
	
	/*
	 * Method to set the destination variable
	 */
	public void setD(String des) {
		d = des;
	}
	
	/*
	 * Method to set the location variable
	 */
	public void setL(String loc) {
		l = loc;
	}
	
	
	/*
	 * Method to serach the json file for all the data for hotels etc.
	 * (non-Javadoc)
	 * @see County#getInfo()
	 */
	public void getInfo(){
		
		JSONParser parser = new JSONParser();
		
		try{
			Object obj = parser.parse(new FileReader("text.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray array = (JSONArray) jsonObject.get("Galway");
			JSONObject o = (JSONObject)array.get(0);
			s = (String) o.get("Synopsis");
			h = (String) o.get("Hotels");
			r = (String) o.get("Restaurants");
			p = (String) o.get("Places");
			t = (String) o.get("Things");
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	
	/*
	 * The method that searches the json file for all the information for each hotel 
	 * (non-Javadoc)
	 * @see County#setDetailHotel(int)
	 */
	public void setDetailHotel(int index){
		
		String file = "text.json";
		JSONParser parser = new JSONParser();
		
		try{
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray array = (JSONArray) jsonObject.get("GalwayHotels");
			
			
			JSONObject o = (JSONObject)array.get(index);
			n = (String) o.get("Name");
			d = (String) o.get("Description");
			l = (String) o.get("Location");
			
			setN(n);
			setD(d);
			setL(l);
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	/*
	 * The method that searches the json file for all the information for each restaurants
	 * (non-Javadoc)
	 * @see County#setDetailR(int)
	 */
	public void setDetailR(int index){
		
		String file = "text.json";
		JSONParser parser = new JSONParser();
		try{
			
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray array = (JSONArray) jsonObject.get("GalwayRestaurants");
			
			JSONObject o = (JSONObject)array.get(index);
			n = (String) o.get("Name");
			d = (String) o.get("Description");
			l = (String) o.get("Location");
			setN(n);
			setD(d);
			setL(l);
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}//end Res
	
	/*
	 * The method that searches the json file for all the information for each Places 
	 * (non-Javadoc)
	 * @see County#setDetailP(int)
	 */
	public void setDetailP(int index){
		
		String file = "text.json";
		JSONParser parser = new JSONParser();
		
		try{
			
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray array = (JSONArray) jsonObject.get("GalwayPlaces");
			
			JSONObject o = (JSONObject)array.get(index);
			n = (String) o.get("Name");
			d = (String) o.get("Description");
			l = (String) o.get("Location");
			System.out.println(n+d+l);
			setN(n);
			setD(d);
			setL(l);
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}//end Places

	/*
	 *  The method that searches the json file for all the information for each things
	 * (non-Javadoc)
	 * @see County#setDetailT(int)
	 */
	public void setDetailT(int index) {
		String file = "text.json";
		JSONParser parser = new JSONParser();
		
		try{
			
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray array = (JSONArray) jsonObject.get("GalwayThings");
			
			JSONObject o = (JSONObject)array.get(index);
			n = (String) o.get("Name");
			d = (String) o.get("Description");
			l = (String) o.get("Location");
			setN(n);
			setD(d);
			setL(l);
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
	}//end Things


}



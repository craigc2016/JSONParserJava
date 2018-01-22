
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.html.HTMLEditorKit.Parser;

import java.io.FileReader; 

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser;



public class ShowKildareInfo  extends JFrame implements ListSelectionListener,ActionListener{
		private County countyKildare = null;
		private JPanel panelCenter,panelWest,panelEast,panelSouth;
		private JLabel la1,la2,la3;
		private ImageIcon head;
		private int size;
		private String out = "",syn;
		private JList<String> t;
		private JButton west1,west2,west3,west4,east1,east2,east3,east4,mainMenu;
		private DefaultListModel<String> def;
		private String name = "images/KildareMap.png";
		private int count =0;
		public static void main(String args[]){
			ShowDublinInfo frame = new ShowDublinInfo();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		public ShowKildareInfo(){
			super("Information Kildare");
			
			
			getContentPane().add(buildCenterPanel(),BorderLayout.CENTER);
			getContentPane().add(buildWestPanel(),BorderLayout.WEST);
			getContentPane().add(buildEastPanel(),BorderLayout.EAST);
			getContentPane().add(buildSouthPanel(),BorderLayout.SOUTH);
			//setBounds(300,100,500,600);
			setResizable(false);
	    	setSize(800,600);
			setVisible(true);
			setLocationRelativeTo(null);
		}//end ShowDublinInfo
		
		/*
		 * Method which builds the center panel and adds the listeners to the JButtons
		 */
		public JPanel buildCenterPanel(){
			countyKildare = new KildareCounty();
			countyKildare.getInfo();
			syn = countyKildare.getSynopsis().getSynop();
			head = new ImageIcon(name);
			
			panelCenter = new JPanel(new GridLayout(3,1));
			panelCenter.setBackground(new Color(124,252,0));
			panelCenter.setForeground(Color.orange);
			
			la3 = new JLabel();
			la2 = new JLabel("<html>" + syn +" <br></html>");
			la1 = new JLabel(head);
			la1.setHorizontalAlignment(JLabel.LEFT);
			la1.setBorder(new LineBorder(Color.ORANGE));
			//System.out.println(outPutText);
			la2.setHorizontalAlignment(JLabel.CENTER);
			la2.setFont(new Font("Serif", Font.PLAIN, 18));
			la2.setBorder(new LineBorder(Color.ORANGE));
			
			la3.setHorizontalAlignment(JLabel.CENTER);
			la3.setFont(new Font("Serif", Font.PLAIN, 18));
			la3.setBorder(new LineBorder(Color.ORANGE));
			
			def = new DefaultListModel();
			t = new JList<String>(def);
			t.setBorder(new LineBorder(Color.ORANGE));
			t.setFont(new Font("Serif", Font.PLAIN, 18));
			t.setBackground(new Color(124,252,0));
			t.addListSelectionListener(this);
			
			panelCenter.add(la1);
			panelCenter.add(la2);
			panelCenter.add(t);
			panelCenter.add(la3);
			
			return panelCenter;
		}//end buildCenterPanel
		
		/*
		 * Method which builds the western panel and adds the listeners to the JButtons
		 */
		public JPanel buildWestPanel(){
			panelWest = new JPanel(new GridLayout(4,1));
			west1 = new JButton("Hotels");
			west2 = new JButton("Resturants");
			west3 = new JButton("Places to Vist");
			west4 = new JButton("Things to do");
			
			west1.setBackground(new Color(245,245,245));
			west2.setBackground(new Color(245,245,245));
			west3.setBackground(new Color(245,245,245));
			west4.setBackground(new Color(245,245,245));
			
			west1.setFont(new Font("Serif", Font.PLAIN, 18));
			west2.setFont(new Font("Serif", Font.PLAIN, 18));
			west3.setFont(new Font("Serif", Font.PLAIN, 18));
			west4.setFont(new Font("Serif", Font.PLAIN, 18));
			
			west1.setBorder(new LineBorder(Color.ORANGE));
			west2.setBorder(new LineBorder(Color.ORANGE));
			west3.setBorder(new LineBorder(Color.ORANGE));
			west4.setBorder(new LineBorder(Color.ORANGE));
			
			west1.addActionListener(this);
			west2.addActionListener(this);
			west3.addActionListener(this);
			west4.addActionListener(this);
			panelWest.add(west1);
			panelWest.add(west2);
			panelWest.add(west3);
			panelWest.add(west4);
			return panelWest;
		}//end buildWestPanel
		
		/*
		 * Method which builds the eastern panel and adds the listeners to the JButtons
		 */
		public JPanel buildEastPanel(){
			panelEast = new JPanel(new GridLayout(4,1));
			east1 = new JButton("Name");
			east2 = new JButton("Description");
			east3 = new JButton("Location");
			east4 = new JButton("Back");
			
			east1.setBackground(new Color(245,245,245));
			east2.setBackground(new Color(245,245,245));
			east3.setBackground(new Color(245,245,245));
			east4.setBackground(new Color(245,245,245));
			
			east1.setFont(new Font("Serif", Font.PLAIN, 18));
			east2.setFont(new Font("Serif", Font.PLAIN, 18));
			east3.setFont(new Font("Serif", Font.PLAIN, 18));
			east4.setFont(new Font("Serif", Font.PLAIN, 18));
			
			east1.setBorder(new LineBorder(Color.ORANGE));
			east2.setBorder(new LineBorder(Color.ORANGE));
			east3.setBorder(new LineBorder(Color.ORANGE));
			east4.setBorder(new LineBorder(Color.ORANGE));
			
			east1.addActionListener(this);
			east2.addActionListener(this);
			east3.addActionListener(this);
			east4.addActionListener(this);
			east1.setEnabled(false);
			east2.setEnabled(false);
			east3.setEnabled(false);
			east4.setEnabled(false);
			panelEast.add(east1);
			panelEast.add(east2);
			panelEast.add(east3);
			panelEast.add(east4);
			return panelEast;
		}//end buildEastPanel
		
		public JPanel buildSouthPanel(){
			panelSouth = new JPanel();
			mainMenu = new JButton("Main Menu");
			mainMenu.setBorder(new LineBorder(Color.ORANGE));
			mainMenu.setFont(new Font("Serif", Font.PLAIN, 18));
			mainMenu.setBackground(new Color(245,245,245));
			mainMenu.addActionListener(this);
			panelSouth.add(mainMenu);
			return panelSouth;
		}//end buildSouthPanel
		
		/*
		 * Method to get the certain hotels,Restaurants,Places,Things
		 * from a json file
		 * @String it takes a parameter of type string to know which list to display
		 */
		public void getResults(String s){
			
			if(s == "Hotels"){
				countyKildare = new KildareCounty();	//create an object of type DublinCounty
				out = countyKildare.getHotels().getHotelName(); //access the methods of DublinCounty
				size=0;
				String[] list =null;
				StringTokenizer st = new StringTokenizer(out); //create a StingTokenizer object to use the object and its method calls
				size = st.countTokens(); //assign the size variable from counting the string tokens e.g each entry for hotels.
				list = new String[size]; //create the array size from the data gained
				
				/*
				 * Loop through the array and assign to the JList
				 */
				for(int i =0;i<list.length;i++){
					list[i] = st.nextToken();
					def.add(i,list[i]);
				}
			}//end hotels
			
			else if(s == "Resturants"){
				countyKildare = new KildareCounty();
				out = countyKildare.getRestaurants().getRestaurant();
				size=0;
				String[] list =null;
				StringTokenizer st = new StringTokenizer(out);
				size = st.countTokens();
				list = new String[size];
				for(int i =0;i<list.length;i++){
					list[i] = st.nextToken();
					def.add(i,list[i]);
				}
				
			}//end Restaurants
			
			else if(s == "Places"){
				countyKildare = new KildareCounty();
				out = countyKildare.getPlacesOfInterests().getPlace();
				size=0;
				String[] list =null;
				StringTokenizer st = new StringTokenizer(out);
				size = st.countTokens();
				list = new String[size];
				for(int i =0;i<list.length;i++){
					list[i] = st.nextToken();
					def.add(i,list[i]);
				}
				
			}//end Places
			
			else if(s == "Things"){
				countyKildare = new KildareCounty();
				out = countyKildare.getThingsToDo().getThing();
				size=0;
				String[] list =null;
				StringTokenizer st = new StringTokenizer(out);
				size = st.countTokens();
				list = new String[size];
				for(int i =0;i<list.length;i++){
					list[i] = st.nextToken();
					def.add(i,list[i]);
				}
			}//end Things
		}//end getResults
		
		

		/*
		 * This method is used to respond to the users actions for the JList
		 * (non-Javadoc)
		 * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
		 */
		public void valueChanged(ListSelectionEvent e) {
			if(e.getValueIsAdjusting()){
				//Hotel List
				if(t.getSelectedValue().equals("KildareHouse")){
					int index = t.getSelectedIndex();
					listDataHotels(index);
				}//end inner if
				else if(t.getSelectedValue().equals("LordEdward")){
					int index = t.getSelectedIndex();
					listDataHotels(index);
				}
				else if(t.getSelectedValue().equals("TheCurraghCountryHouse")){
					int index = t.getSelectedIndex();
					listDataHotels(index);
				}
				else if(t.getSelectedValue().equals( "CloncarlinHouse")){
					int index = t.getSelectedIndex();
					listDataHotels(index);
				}
				//Restaurants List
				else if(t.getSelectedValue().equals("HartesOfKildare")){
					int index = t.getSelectedIndex();
					listDataRes(index);
				}
				else if(t.getSelectedValue().equals("SitaarayIndianRestaurant")){
					int index = t.getSelectedIndex();
					listDataRes(index);
				}
				else if(t.getSelectedValue().equals("IlPonteNuovo")){
					int index = t.getSelectedIndex();
					listDataRes(index);
				}
				else if(t.getSelectedValue().equals("TheHangedMan")){
					int index = t.getSelectedIndex();
					listDataRes(index);
				}
				//Places to Vist
				else if(t.getSelectedValue().equals("SaintBrigid'sCathedralandRoundTower")){
					int index = t.getSelectedIndex();
					listDataPlace(index);
				}
				else if(t.getSelectedValue().equals("KildareVillage")){
					int index = t.getSelectedIndex();
					listDataPlace(index);
				}
				else if(t.getSelectedValue().equals("TheCurraghRacecourse")){
					int index = t.getSelectedIndex();
					listDataPlace(index);
				}
				else if(t.getSelectedValue().equals("KildareTownHeritageCentre&TouristOffice")){
					int index = t.getSelectedIndex();
					listDataPlace(index);
				}
				//Things List
				else if(t.getSelectedValue().equals("IrishNationalStud&Gardens")){
					int index = t.getSelectedIndex();
					listDataThings(index);
				}
				else if(t.getSelectedValue().equals("WallabyWoodsDonadea")){
					int index = t.getSelectedIndex();
					listDataThings(index);
				}
				else if(t.getSelectedValue().equals("AceCasino")){
					int index = t.getSelectedIndex();
					listDataThings(index);
				}
				else if(t.getSelectedValue().equals("HighfieldGolfandCountryClub")){
					int index = t.getSelectedIndex();
					listDataThings(index);
				}
				
			}//end if
		}//end ItemPerformed
		
		/*Method used for the JButtons and responds to the user's actions
		 * (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == west1){
				count++;
				if(count == 1){
					west1.setEnabled(false);
				}
				getResults(west1.getText());
				west2.setEnabled(false);
				west3.setEnabled(false);
				west4.setEnabled(false);
			}
			else if(e.getSource() == west2){
				count++;
				if(count == 1){
					west2.setEnabled(false);
				}
				getResults(west2.getText());
				west1.setEnabled(false);
				west3.setEnabled(false);
				west4.setEnabled(false);
			}
			else if(e.getSource() == west3){
				count++;
				if(count == 1){
					west3.setEnabled(false);
				}
				String p = "Places";
				getResults(p);
				west1.setEnabled(false);
				west2.setEnabled(false);
				west4.setEnabled(false);
			}
			else if(e.getSource() == west4){
				count++;
				if(count == 1){
					west4.setEnabled(false);
				}
				String v = "Things";
				getResults(v);
				west1.setEnabled(false);
				west2.setEnabled(false);
				west3.setEnabled(false);
			}
			else if(e.getSource() == east1){
				String result = countyKildare.getNames().getName();
				la3.setText(result);
			}
			else if(e.getSource() == east2){
				String result = countyKildare.getDescriptions().getDescription();
				la3.setText("<html>" + result +  "<br></html>");
			}
			else if(e.getSource() == east3){
				String result = countyKildare.getLocations().getLocation();
				la3.setText("<html>" + result +  "<br></html>");
			}
			else if(e.getSource() == east4){
				west1.setEnabled(true);
				west2.setEnabled(true);
				west3.setEnabled(true);
				west4.setEnabled(true);
				reset(); // method call to reset the application
			}
			else if(e.getSource() == mainMenu){
				new Planner();
				dispose();
			}
		}//end actionPerformed
		
		/*
		 * Method that searchs the json file depending on the user input
		 */
		public void listDataHotels(int index){
			countyKildare.setDetailHotel(index);
			String output = countyKildare.getNames().getName() + countyKildare.getDescriptions().getDescription() + countyKildare.getLocations().getLocation();
			east1.setEnabled(true);
			east2.setEnabled(true);
			east3.setEnabled(true);
			east4.setEnabled(true);
		}//end listData
		
		public void listDataRes(int index){
			countyKildare.setDetailR(index);
			String output = countyKildare.getNames().getName() + countyKildare.getDescriptions().getDescription() + countyKildare.getLocations().getLocation();
			east1.setEnabled(true);
			east2.setEnabled(true);
			east3.setEnabled(true);
			east4.setEnabled(true);
		}//end listData
		
		public void listDataPlace(int index){
			countyKildare.setDetailP(index);
			
			String output = countyKildare.getNames().getName() + countyKildare.getDescriptions().getDescription() + countyKildare.getLocations().getLocation();
			east1.setEnabled(true);
			east2.setEnabled(true);
			east3.setEnabled(true);
			east4.setEnabled(true);
		}//end listData
		
		public void listDataThings(int index){
			countyKildare.setDetailT(index);
			String output = countyKildare.getNames().getName() + countyKildare.getDescriptions().getDescription() + countyKildare.getLocations().getLocation();
			east1.setEnabled(true);
			east2.setEnabled(true);
			east3.setEnabled(true);
			east4.setEnabled(true);
		}//end listData
		
		/*
		 * Method to reset the applications Jbuttons and clear the JLabel
		 */
		public void reset(){
			west1.setEnabled(true);
			west2.setEnabled(true);
			west3.setEnabled(true);
			west4.setEnabled(true);
			east1.setEnabled(false);
			east2.setEnabled(false);
			east3.setEnabled(false);
			east4.setEnabled(false);
			la3.setText("");
			def.clear();
			count =0;
		}
		
		
	
}//end class



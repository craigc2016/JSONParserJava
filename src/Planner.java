import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Planner extends JFrame implements ActionListener{//start class
	private JButton dublin,kildare,cork,galway,dis,b;
	private JPanel panelc,panels;
	//private static County count = null;
	private static String out="";
	private JLabel label1,label2;
	private ImageIcon image;
	public static void main(String[] args) {//start main method
		
		Planner frame = new Planner();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}//end main method
	
	public Planner(){
		super("Holiday Planner");
		buildGUI();
		setCloseClick();
	}
	
    private void setCloseClick() {
        //create window listener to respond to window close click
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  System.exit(0);
                              }
                          });
    }
	
	public void buildGUI(){
		Container con = getContentPane();
		con.add(buildSouthPanel(),BorderLayout.SOUTH);
		con.add(buildCenterPanel(),BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setBounds(300,100,500,600);
	    setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public JPanel buildSouthPanel(){
		panels = new JPanel(new GridLayout(1,1));
		dublin= new JButton("Dublin");
		kildare = new JButton("Kildare");
		cork = new JButton("Cork");
		galway = new JButton("Galway");
		
		dublin.setBackground(new Color(245,245,245));
		kildare.setBackground(new Color(245,245,245));
		cork.setBackground(new Color(245,245,245));
		galway.setBackground(new Color(245,245,245));
		
		dublin.setFont(new Font("Serif", Font.PLAIN, 18));
		kildare.setFont(new Font("Serif", Font.PLAIN, 18));
		cork.setFont(new Font("Serif", Font.PLAIN, 18));
		galway.setFont(new Font("Serif", Font.PLAIN, 18));
		
		dublin.setBorder(new LineBorder(Color.ORANGE));
		kildare.setBorder(new LineBorder(Color.ORANGE));
		cork.setBorder(new LineBorder(Color.ORANGE));
		galway.setBorder(new LineBorder(Color.ORANGE));
		
		panels.add(dublin);
		panels.add(kildare);
		panels.add(cork);
		panels.add(galway);
		dublin.addActionListener(this);
		kildare.addActionListener(this);
		cork.addActionListener(this);
		galway.addActionListener(this);
		return panels;
	}
	
	public JPanel buildCenterPanel(){
		panelc = new JPanel(new GridLayout(2,1));
		label2 = new JLabel("Ireland Planner");
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setFont(new Font("Serif", Font.BOLD, 50));
		label2.setBorder(new LineBorder(Color.ORANGE));
		image = new ImageIcon("images/ireMap.png");
		label1 = new JLabel(image);
		label1.setBorder(new LineBorder(Color.ORANGE));
		panelc.setBackground(new Color(124,252,0));
		
		//t = new JTextArea();
		//t.setHorizontalAlignment(JLabel.CENTER);
		panelc.add(label1);
		panelc.add(label2);
		//panelc.add(t);
		return panelc;
	}
	
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == dublin){
			new ShowDublinInfo();
			dispose();
			
		}
		else if(obj == kildare){
			new ShowKildareInfo();
			dispose();
		}
		else if(obj == cork){
			new ShowCorkInfo();
			dispose();
		}
		else if(obj == galway){
			new ShowGalwayInfo();
			dispose();
		}
		
	}//end actionPerformed
	
	

}//end class

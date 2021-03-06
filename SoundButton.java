
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.applet.*;
import java.io.*;
import javax.sound.*;




public class SoundButton extends JFrame implements ActionListener {
	
	private Container c;
	private JButton button1;
	private JButton button2;
	
	public Soundbutton() {
		super("Sound zum Spiel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		button1 = new JButton("Hintergrundmusik");
		button2 = new JButton("Stoss-musik"); /* Also Die Musik wenn sich die Figur gegen eine 
		                                         eine Wand l�uft*/
		button1.addActionListener(this);
		button2.addActionListener(this);
		c.add(button1);
		c.add(button2);
		
		setSize (400,500);
		setVisible(true);
		
	}
		
		public void ActionPerfomed (ActionEvent e) {
			Object angeklickt = e.getSource();
			File music1 = new File("./src/jack_in_the_box_fast-Mike_Koenig-1288903495.wav");
			File music2 = new File("./src/Mario_Jumping-Mike_Koenig-989896458.wav");
			
			if( angeklickt == button1);
			music1.play(); // music.loop() im spiel sp�ter
					
			if( angeklickt == button2);
			music2.play();
			
			
					
					}
	
	public static void main(String[] args) {
		new Soundbutton();

	}

}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class start extends JFrame implements ActionListener{
	
	private JButton schliessen;
	private JButton einstellung;
	private JButton info;
	private JButton ende;
	static int SLEEP_TIME = 10;
	
	public static void main(String[] args) {
		
		start frame = new start("Menue");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,350);
		
		frame.setLayout(null);
		frame.setVisible(true);

	}
	
	public start(String title){
		super(title);
		schliessen = new JButton("Spiel starten");
		schliessen.addActionListener(this);
		schliessen.setBounds(120,40,160,40);
		add(schliessen);
		
		einstellung = new JButton("einstellung");
		einstellung.addActionListener(this);
		einstellung.setBounds(120,120,160,40);
		add(einstellung);
		
		info = new JButton("info");
		info.addActionListener(this);
		info.setBounds(120,200,160,40);
		add(info);
		
		ende = new JButton("ende");
		ende.addActionListener(this);
		ende.setBounds(120,280,160,40);
		add(ende);
	}
	
	public static void frame(){
		start frame = new start("Menue");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,350);
		
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public static void fenster(){
		Frame frame = new Frame();
		/*Game game = new Game();
		long time;
		long timeDiff;
		Date date = new Date();
		
		while (game.scene != null) {
			
			time = date.getTime();
			
			try {
				game.update();
			}
			catch (Exception e) {
				//Irgendeine unerwartete Exception
				e.printStackTrace();
			}
			
			timeDiff = date.getTime() - time;
			
			if (SLEEP_TIME-timeDiff > 0) {
				try {
					Thread.sleep(SLEEP_TIME-timeDiff);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.exit(0);
		*/
		
		
	}
	
public static void auswahl(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==schliessen){
			
			fenster();
			
		}
		
		if (e.getSource()==info){
			Object[] options = {"OK"};
			
			JOptionPane.showOptionDialog(null, "Progammiert von Hyojin Lee", "Informatino", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
		}
		
		if (e.getSource()==einstellung){
			 auswahl();
		}
		
		if (e.getSource()==ende){
			System.exit(0);
		}
	}
	
	
}



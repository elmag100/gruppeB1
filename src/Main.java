import java.awt.Color;
import java.awt.Font;
import java.util.Date;

/*
 * 
 * Main.java
 * Die Klasse Main ist die Klasse, die das gesamte Programm startet. Daf�r kann sie eigentlich
 * nicht viel.
 * Sie erstellt ein Game Objekt und f�hrt dann den gameloop solange aus, wie
 * game.scene nicht auf null zeigt.
 * Dadurch kann das Spiel sich selbst ganz bequem beenden indem man in einer Scene einfach
 * 
 * 				game.scene = null;
 * 
 * schreibt. Eventuelle Aufr�umarbeiten (Dateien schlie�en, etc.) k�nnen dann noch hier
 * ausgef�hrt werden, bevor das Programm sich komplett beendet.
 * 
 */

public class Main {
	
	static int SLEEP_TIME = 10;
	
	public static void main(String[] args) {
		
		Game game = new Game();
		long time;
		long timeDiff;
		
		//Gameloop
		while (game.scene != null) {
			
			time = System.currentTimeMillis();
			game.update();
			
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			timeDiff = System.currentTimeMillis() - time;
			if (timeDiff < SLEEP_TIME) {
				try {
					Thread.sleep(SLEEP_TIME-timeDiff);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Math.round(1000.0/timeDiff));
		}
		
		//Programm per System.exit(0) beenden, damit auch die
		//Swing-Anwendungen geschlossen werden!
		System.exit(0);
	}
}
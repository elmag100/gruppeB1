/*
 * Game.java
 * Dies ist die Hauptklasse, welche den Screen und den KeyHandler (später auch evtl.
 * noch weitere global zugängliche Objekte) bereitstellt.
 * Hier wird die aktuelle auszuführende Szene gespeichert und geupdatet.
 * 
 * Die Methode game.update(), deren Ausführung genau einem Frame entspricht wird dann
 * letztendlich im Gameloop der Klasse Main aufgerufen.
 */

public class Game {

	static String GAME_TITLE = "ProPra - 1. Meilenstein";
	
	Scene scene;
	
	private Screen screen;
	private KeyHandler keyhandler;
	
	Game() {
		
		//Screen und KeyHandler initialisieren
		keyhandler = new KeyHandler();
		screen = new Screen();
		scene = new Scene_Map(this);
		
		screen.setTitle(GAME_TITLE);
		screen.addKeyListener(keyhandler);
		screen.setVisible(true);
	}

	//Die Ausführung dieser Methode entspricht genau einem Frame
	public void update() {
		scene.update();
		keyhandler.freezeUpdate();		//Der Counter von eingefrorenen Tasten wird
										//in jedem Frame dekrementiert
		screen.update();
	}

	//Getter / Setter
	
	public Screen getScreen() {
		return screen;
	}

	public KeyHandler getKeyHandler() {
		return keyhandler;
	}

}

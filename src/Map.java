import java.io.*;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Map.java
 * Diese Klasse ist eigentlich nur ein Container, der ein TileSet und ein
 * Datenfeld enth�lt, welches die Map repr�sentiert.
 * Das Datenfeld ist einfach ein zweidimensionales int Array. Die Zahlen darin
 * entsprechen den IDs des Tiles an der jeweiligen Position im Screen. Siehe dazu
 * im Konstruktor von Game nach. Dort wird das Datenfeld einer Testmap initialisiert.
 * Wichtig ist die Funktion Map.getLowMapImage()
 * Hier wird die komplette Map als Bild gerendert und dann zur�ckgegeben (siehe Screen.update)
 */

public class Map {
	
	static int TILESIZE = 32;
	
	boolean scrolling;
	
	private TileSet			tileset;
	private int 			width;
	private int 			height;
	private int 			gen_counter = 2;
	private int[][] 		lowmap;
	private int[][] 		highmap;
	private BufferedImage 	low_map_image;
	private BufferedImage 	high_map_image;
	
	Map(String mapname) {
		String filename = "res/maps/"+mapname+".txt";
		try {
			readData(filename);
		} catch (IOException e) {
			// Datei besch�digt!
			e.printStackTrace();
		}
	}
	
	public TileSet getTileset() {
		return tileset;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public Event[] getEvents() {
		return null;
	}
	
	public boolean isPassable(int x, int y) {
		if (y >= height) return false;
		if (lowmap[y][x] == 0  ||  lowmap[y][x] == 4) {
			return true;
		}
		return false;
	}
	
	public BufferedImage getLowMapImage() {
		//'gen_counter' z�hlt runter, wie oft das Mapbild generiert wurde. Aus irgendeinem
		//Grund muss dies n�mlich mindestens zwei mal geschehen, damit das Bild vollst�ndig
		//ist und als fertiges Bild im Speicher gehalten werden kann
		if (gen_counter == 0) {
			return low_map_image;
		}
		gen_counter--;
		BufferedImage b = new BufferedImage(TILESIZE*width,
				TILESIZE*height,
				BufferedImage.TYPE_INT_ARGB);
		for (int y=0; y<height; y++) {
			for (int x=0; x<width; x++) {
				//sp�ter getFloor(), etc. durch getTile(ID) ersetzen um beliebige Tiles zu
				//bekommen! Sp�testens dann auch subImages oder so benutzen
				b.getGraphics().drawImage(tileset.getTile(lowmap[y][x]),
						x*TILESIZE,
						y*TILESIZE,
						null);
			}
		}
		low_map_image = b;
		return b;
	}
	
	private void readData(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		tileset = new TileSet(br.readLine());
		width = Integer.parseInt(br.readLine());
		height = Integer.parseInt(br.readLine());
		//hier wird erstmal geskippt, muss sp�ter noch ge�ndert werden
		br.readLine();
		br.readLine();
		lowmap = new int[height][width];
		String[] line;
		int[] i_line = new int[width];
		for (int y=0; y<height; y++) {
			line = br.readLine().split(" ");
			for (int i=0; i<width; i++) i_line[i] = Integer.parseInt(line[i]);
			for (int x=0; x<width; x++) {
				lowmap[y][x] = i_line[x];
			}
		}
		br.close();
	}
}

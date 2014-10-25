package workspaceState;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.paint.Color;

public class ColorPalette {
	private Map<Integer,Color> colorPalette = new HashMap<Integer,Color>();
	
	public ColorPalette(){
		// add some defaults
		addColorToPalette(Color.WHITE,0);
		addColorToPalette(Color.RED,1);
		addColorToPalette(Color.ORANGE,2);
		addColorToPalette(Color.YELLOW,3);
		addColorToPalette(Color.GREEN,4);
		addColorToPalette(Color.BLUE,5);
		addColorToPalette(Color.INDIGO,6);
		addColorToPalette(Color.VIOLET,7);
		addColorToPalette(Color.BLACK,8);
	}
	
	public void addColorToPalette(Color color, int ID){
		colorPalette.put(ID, color);
	}
	
	public void addColorToPalette(String color, int ID){
		colorPalette.put(ID, Color.valueOf(color));
	}
	
	public void addColorToPalette(double r, double g, double b, int ID){
		colorPalette.put(ID, Color.color(r,g,b));
	}
	
	public Color getColor(int ID){
		return colorPalette.get(ID);
	}
	
	public String getColorAsString(int ID){
		return colorPalette.get(ID).toString();
	}
}

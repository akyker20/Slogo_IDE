package workspaceState;

import javafx.scene.paint.Color;

public class ColorPalette extends Palette<Color> {
	
	public ColorPalette(){
		// add some defaults
		addToPalette(0,Color.WHITE);
		addToPalette(1,Color.RED);
		addToPalette(2,Color.ORANGE);
		addToPalette(3,Color.YELLOW);
		addToPalette(4,Color.GREEN);
		addToPalette(5,Color.BLUE);
		addToPalette(6,Color.INDIGO);
		addToPalette(7,Color.VIOLET);
		addToPalette(8,Color.BLACK);
	}
	
	public void addColorToPalette(int ID, Color color){
		addToPalette(ID, color);
	}
	
	public void addColorToPalette(int ID, String color){
		addToPalette(ID, Color.valueOf(color));
	}
	
	public void addColorToPalette(int ID, double r, double g, double b){
		addToPalette(ID, Color.color(r,g,b));
	}
	
	public Color getColor(int ID){
		return getFromPalette(ID);
	}
	
	public String getColorAsString(int ID){
		return getFromPalette(ID).toString();
	}
}

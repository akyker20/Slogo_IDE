package workspaceState;

import javafx.scene.paint.Color;

public class Pen {

	private boolean isPenDown;
	private Color myPenColor;
	private double thickness;
	
	public Pen(){
		isPenDown = true;
		myPenColor = Color.BLACK;
		thickness = 1;
	}

	public Pen(Pen pen) {
		isPenDown = pen.isPenDown;
		myPenColor = pen.myPenColor;
		thickness = pen.thickness;
	}

	public void togglePenDown() {
		isPenDown = true;
	}

	public void togglePenUp() {
		isPenDown = false;
	}

	public boolean isPenDown() {
		return isPenDown;
	}

	public Color getPenColor() {
		return myPenColor;
	}

	public void setPenColor(Color myPenColor) {
		this.myPenColor = myPenColor;
	}
	
	public void setPenSize(double size){
		thickness = size;
	}
	
	public double getPenSize(){
		return thickness;
	}
}

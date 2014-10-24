package workspaceState;

import javafx.scene.paint.Color;

public class Pen {
	
	private boolean isPenDown = true;
    private Color myPenColor;

	public void togglePenDown(){
		isPenDown = true;
	}

	public void togglePenUp(){
		isPenDown = false;
	}

	public boolean isPenDown(){
		return isPenDown;
	}
	
    public Color getPenColor () {
        return myPenColor;
    }

    public void setPenColor (Color myPenColor) {
        this.myPenColor = myPenColor;
    }
}

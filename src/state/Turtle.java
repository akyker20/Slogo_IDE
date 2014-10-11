package state;

import java.io.Serializable;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Turtle implements Serializable {
    
	private static final long serialVersionUID = 483416034032716037L;
	// degrees from north
    private static final double DEFAULT_TURTLE_HEADING = 0.0;

    private double myHeading;
    private Color myPenColor;
    private Location myLocation;
    private double myOpacity = 100;
    private boolean penState = true;
    private boolean turtleShowing = true;
    private String ID;

    public Turtle () {
        // call setImage() before setLocation() and setHeading()

        myLocation = new Location(0,0);
        myHeading = DEFAULT_TURTLE_HEADING;
    }
    
    public void togglePenDown(){
        penState = true;
    }

    public void togglePenUp(){
        penState = false;
    }

    public boolean isPenDown(){
        return penState;
    }

    public void showTurtle(){
        turtleShowing = true;
        setOpacity(100);
    }

    public void hideTurtle(){
        turtleShowing = false;
        setOpacity(0);
    }

    public boolean isTurtleShowing(){
        return turtleShowing;
    }
    
    public void setOpacity(double opacity){
    	myOpacity = opacity;
    }
    
    public double getOpacity(){
    	return myOpacity;
    }

    public double getHeading () {
        return myHeading;
    }

    public void setHeading (double myHeading) {
        this.myHeading = myHeading;
    }

    public Color getPenColor () {
        return myPenColor;
    }

    public void setPenColor (Color myPenColor) {
        this.myPenColor = myPenColor;
    }

    public Location getLocation () {
        return myLocation;
    }

    public void setLocation (Location myLocation) {
        this.myLocation = myLocation;
    }

    public String getID () {
        return ID;
    }
    
    public void setID (String someID) {
        ID = someID;
    }
}

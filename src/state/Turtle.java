package state;

import java.io.Serializable;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Turtle implements Serializable {
    
	private static final long serialVersionUID = 483416034032716037L;
	// degrees from north
    private static final double DEFAULT_TURTLE_HEADING = 0.0;
    private static final Color DEFAULT_TURTLE_PENCOLOR = Color.BLACK;
    private static final boolean DEFAULT_TURTLE_PENDOWN_STATUS = false;
    private static final Point2D DEFAULT_TURTLE_LOCATION = new Point2D(0,0);

    private double myHeading;
    private Color myPenColor;
    private Point2D myLocation;
    private boolean myPenDownStatus;

    public Turtle () {
        // call setImage() before setLocation() and setHeading()

        myLocation = DEFAULT_TURTLE_LOCATION;
        myHeading = DEFAULT_TURTLE_HEADING;
        myPenColor = DEFAULT_TURTLE_PENCOLOR;
        myPenDownStatus = DEFAULT_TURTLE_PENDOWN_STATUS;
    }

    public double getHeading () {
        return 90-myHeading;
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

    public Point2D getLocation () {
        return myLocation;
    }

    public void setLocation (Point2D myLocation) {
        this.myLocation = myLocation;
    }

    public boolean isPenDown() {
        return myPenDownStatus;
    }

    public void setPenDownStatus (boolean myPenDownStatus) {
        this.myPenDownStatus = myPenDownStatus;
    }

   
}

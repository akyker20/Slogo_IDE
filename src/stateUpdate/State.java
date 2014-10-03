package stateUpdate;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class State {
	private double heading;
	private Color penColor;
	private Point2D turtleLocation;
	
	public State(double someHeading, Color someColor, Point2D someLocation){
		heading = someHeading;
		penColor = someColor;
		turtleLocation = someLocation;
	}
}

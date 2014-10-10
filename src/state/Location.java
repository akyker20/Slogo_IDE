package state;

import java.io.Serializable;

public class Location implements Serializable {

	private static final long serialVersionUID = -6402217875758076841L;
	private double xLocation;
	private double yLocation;
	
	public Location(double x, double y){
		xLocation = x;
		yLocation = y;
	}
	
	public void add(double x, double y){
		xLocation +=x;
		yLocation +=y;
	}
	
	public double getX(){
		return xLocation;
	}
	
	public double getY(){
		return yLocation;
	}
	
	public void add(Location loc){
		xLocation += loc.xLocation;
		yLocation += loc.yLocation;
	}
}

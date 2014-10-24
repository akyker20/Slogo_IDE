package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Location {

	private double xLocation;
	private double yLocation;
	
	public Location(double x, double y){
		xLocation = x;
		yLocation = y;
	}
	
	public Location(Location location) {
		xLocation = location.getX();
		yLocation = location.getY();
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
	
	public String generateLocationString(){
		List<Double> location = new ArrayList<Double>(){{
			add(xLocation);
			add(yLocation);
		}};

		return location.stream()
				.map(p -> p.toString())
				.collect(Collectors.joining(" ")); 
	}
}

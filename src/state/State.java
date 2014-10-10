package state;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import commandParsing.exceptions.RunTimeNullPointerException;

public class State implements Serializable {

	private static final long serialVersionUID = 3972409856487518925L;
	private Turtle turtle; 
	private boolean penState = true;
    private Map<String, Double> variableMap;

    public State (Turtle someTurtle, Map<String,Double> variables) {
        turtle = someTurtle;
        variableMap = variables;
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
    
    public void storeVariable(String name, double value){
    	variableMap.put(name, variableMap.getOrDefault(name, (double) 0) - variableMap.getOrDefault(name, (double) 0) + value);
    }
    
    public double fetchVariable(String name) throws RunTimeNullPointerException{
    	if(!variableMap.keySet().contains(name)){
    		throw new RunTimeNullPointerException(name);
    	}
    	return variableMap.get(name); 
    }
    
    public double getHeading(){
    	return turtle.getHeading();
    }
    
    private double getTurtleXLocation(){
    	return turtle.getLocation().getX();
    }
    
    private double getTurtleYLocation(){
    	return turtle.getLocation().getY();
    }
    
	public List<Double> calculateLocation(){
		@SuppressWarnings("serial")
		List<Double> location = new ArrayList<Double>(){{
			add(getTurtleXLocation());
			add(getTurtleYLocation());
		}};
		
		return location; 
	}
    
    public void move(double amount){
		double heading = turtle.getHeading();
		double xDisplacement = roundToHundredths(amount*Math.cos(heading/(180/Math.PI)));
		double yDisplacement = roundToHundredths(amount*Math.sin(heading/(180/Math.PI)));
		turtle.setLocation(turtle.getLocation().add(xDisplacement, yDisplacement));
    }
	
	private double roundToHundredths(double number){
		return Math.round(number*100)/100;
	}
	
	public void rotateLeft(double amount) {
		turtle.setHeading((turtle.getHeading()+amount)%360);
	}
	
	public void rotateRight(double amount) {
		turtle.setHeading((turtle.getHeading()-amount)%360);
	}
}

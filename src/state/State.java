package state;

import java.util.Map;

import commandParsing.exceptions.RunTimeNullPointerException;

public class State {
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
    
    public double getTurtleXLocation(){
    	return turtle.getLocation().getX();
    }
    
    public double getTurtleYLocation(){
    	return turtle.getLocation().getY();
    }

	public void moveBackward(double amount) {
		double heading = turtle.getHeading();
		turtle.setLocation(turtle.getLocation().add(-amount*Math.cos(heading/(180/Math.PI)), -amount*Math.sin(heading/(180/Math.PI))));
	}
	
	public void moveForward(double amount) {
		double heading = turtle.getHeading();
		turtle.setLocation(turtle.getLocation().add(amount*Math.cos(heading/(180/Math.PI)), amount*Math.sin(heading/(180/Math.PI))));
	}
	
	public void rotateLeft(double amount) {
		turtle.setHeading((turtle.getHeading()+amount)%360);
	}
	
	public void rotateRight(double amount) {
		turtle.setHeading((turtle.getHeading()-amount)%360);
	}
}

package stateUpdate;

import gui.turtle.Turtle;

import java.util.Map;

import commandParsing.exceptions.RunTimeNullPointerException;

public class State {
	private Turtle turtle; 
    private Map<String, Float> variableMap;

    public State (Turtle someTurtle, Map<String,Float> variables) {
        turtle = someTurtle;
        variableMap = variables;
    }
    
    public void storeVariable(String name, float value){
    	variableMap.put(name, variableMap.getOrDefault(name, (float) 0) - variableMap.getOrDefault(name, (float) 0) + value);
    }
    
    public float fetchVariable(String name) throws RunTimeNullPointerException{
    	if(!variableMap.keySet().contains(name)){
    		throw new RunTimeNullPointerException(name);
    	}
    	return variableMap.get(name); 
    }
    
    public float getHeading(){
    	return (float) turtle.getHeading();
    }
    
    public double getXLocation(){
    	return turtle.getLocation().getX();
    }
    
    public double getYLocation(){
    	return turtle.getLocation().getY();
    }

	public void moveBackward(float amount) {
		double heading = turtle.getHeading();
		turtle.setLocation(turtle.getLocation().add(-amount*Math.cos(heading/(180/Math.PI)), -amount*Math.sin(heading/(180/Math.PI))));
	}
	
	public void moveForward(float amount) {
		double heading = turtle.getHeading();
		turtle.setLocation(turtle.getLocation().add(amount*Math.cos(heading/(180/Math.PI)), amount*Math.sin(heading/(180/Math.PI))));
	}
	
	public void rotateLeft(float amount) {
		turtle.setHeading(turtle.getHeading()-amount);
	}
	
	public void rotateRight(float amount) {
		turtle.setHeading(turtle.getHeading()+amount);
	}
}

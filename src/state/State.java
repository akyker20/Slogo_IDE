package state;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import translator.Translator;

import commandParsing.exceptions.RunTimeNullPointerException;

public class State implements Serializable {

	private static final long serialVersionUID = 3972409856487518925L;
	private Translator translator;
	private Turtle turtle; 
	private boolean penState = true;
	private boolean turtleShowing = true;
    private Map<String, Double> variableMap;

    public State (Turtle someTurtle, Map<String,Double> variables, Translator someTranslator) {
        turtle = someTurtle;
        variableMap = variables;
        translator = someTranslator;
    }
    
    public void setOpacity(double opacity){
    	turtle.setOpacity(opacity);
    }
    
    public double getOpacity(){
    	return turtle.getOpacity();
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
    }
    
    public void hideTurtle(){
    	turtleShowing = false;
    }
    
    public boolean isTurtleShowing(){
    	return turtleShowing;
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
    
	public List<Double> calculateLocation(){
		@SuppressWarnings("serial")
		List<Double> location = new ArrayList<Double>(){{
			add(getTurtleXLocation());
			add(getTurtleYLocation());
		}};
		
		return location; 
	}
    
    public void move(double amount){
		double heading = 90-turtle.getHeading();
		double xDisplacement = roundToHundredths(amount*Math.cos(heading/(180/Math.PI)));
		double yDisplacement = roundToHundredths(amount*Math.sin(heading/(180/Math.PI)));
		turtle.getLocation().add(xDisplacement, yDisplacement);
    }
    
    public void move(double xMovement, double yMovement){
    	turtle.getLocation().add(xMovement,yMovement);
    }
	
	private double roundToHundredths(double number){
		return Math.round(number*100)/100;
	}
	
	public void rotate(double amount) {
		turtle.setHeading((turtle.getHeading()+amount)%360);
	}
	
	public String getVariablePattern(){
		return translator.getVariablePattern();
	}
	
	public String getConstantPattern(){
		return translator.getConstantPattern();
	}
	
	public String getCommandPattern(){
		return translator.getCommandPattern();
	}
	
	public String getListStartPattern(){
		return translator.getListStartPattern();
	}
	
	public String getListEndPattern(){
		return translator.getListEndPattern();
	}
	
	public Iterator<String> translate(String string){
		return translator.translate(string);
	}
}

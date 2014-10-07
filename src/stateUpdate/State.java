package stateUpdate;

import java.util.HashMap;
import java.util.Map;

import commandParsing.exceptions.RunTimeNullPointerException;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;


/**
 * Class holds GUI state
 *
 * @author steven, stanley
 *
 */

public class State {
    private float heading;
    private Color penColor;
    private Point2D turtleLocation;
    private Map<String, Float> variableMap;

    public State (float someHeading, Color someColor, Point2D someLocation, HashMap<String,Float> variables) {
        heading = someHeading;
        penColor = someColor;
        turtleLocation = someLocation;
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
    	return heading;
    }

	public void moveBackward(float amount) {
				
	}
	
	public void moveForward(float amount) {
		
	}
	
	public void rotateLeft(float amount) {
		
	}
	
	public void rotateRight(float amount) {
		
	}
}

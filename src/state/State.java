package state;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import translator.Translator;
import commandParsing.exceptions.RunTimeNullPointerException;

public class State implements Serializable {

    private static final long serialVersionUID = 3972409856487518925L;
    private Translator translator;
    private Map<String,Turtle> turtleMap; 
    private Turtle activeTurtle;
    private Map<String, Double> variableMap;
    private Map<String,List<String>> userDefinedCommandMap;
    
    public State (Turtle someTurtle, Map<String,Double> variables, Translator someTranslator) {
    	userDefinedCommandMap = new HashMap<String,List<String>>();
    	turtleMap = new HashMap<String,Turtle>();
        addTurtle(someTurtle);
        variableMap = variables;
        translator = someTranslator;
    }

    public void addTurtle(Turtle someTurtle) {
        String turtleID = String.valueOf(turtleMap.size());
        turtleMap.put(turtleID,someTurtle);
        activateTurtle(turtleID);
    }

    public void activateTurtle(String turtleID) {
        activeTurtle = turtleMap.get(turtleID);
    }

    public double getOpacity(){
        return activeTurtle.getOpacity();
    }

    public void togglePenDown(){
        activeTurtle.togglePenDown();
    }

    public void togglePenUp(){
        activeTurtle.togglePenUp();
    }

    public boolean isPenDown(){
        return activeTurtle.isPenDown();
    }

    public void showTurtle(){
        activeTurtle.showTurtle();
    }

    public void hideTurtle(){
        activeTurtle.hideTurtle();
    }

    public boolean isTurtleShowing(){
        return activeTurtle.isTurtleShowing();
    }
    

    public double getHeading(){
        return activeTurtle.getHeading();
    }

    public double getTurtleXLocation(){
        return activeTurtle.getLocation().getX();
    }

    public double getTurtleYLocation(){
        return activeTurtle.getLocation().getY();
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
        double heading = 90-activeTurtle.getHeading();
        double xDisplacement = roundToHundredths(amount*Math.cos(heading/(180/Math.PI)));
        double yDisplacement = roundToHundredths(amount*Math.sin(heading/(180/Math.PI)));
        activeTurtle.getLocation().add(xDisplacement, yDisplacement);
    }

    private double roundToHundredths(double number){
        return Math.round(number*100)/100;
    }

    public void rotate(double amount) {
        activeTurtle.setHeading((activeTurtle.getHeading()+amount)%360);
    }

    public void storeVariable(String name, double value){
        variableMap.put(name, variableMap.getOrDefault(name, (double) 0) - 
        		              variableMap.getOrDefault(name, (double) 0) + value);
    }

	public void incrementVariable(String loopVariable, double incrementAmount) {
        variableMap.put(loopVariable, variableMap.getOrDefault(loopVariable, (double) 0) + incrementAmount);
	}

    public double fetchVariable(String name) throws RunTimeNullPointerException{
        if(!variableMap.keySet().contains(name)){
            throw new RunTimeNullPointerException(name);
        }
        return variableMap.get(name); 
    }
    
    public boolean variableExists(String name){
    	return variableMap.containsKey(name);
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

    public void moveToLocation(Location loc) {
        activeTurtle.setLocation(loc);
    }

    public String getCurrentTurtleID () {
        return activeTurtle.getID();
    }

    public void storeUserDefinedCommand(String name, List<String> commands){
    	userDefinedCommandMap.put(name, commands);
    }
}

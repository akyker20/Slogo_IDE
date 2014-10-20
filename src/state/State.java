package state;

import gui.variableslist.WorkspaceVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import translator.Translator;

import commandParsing.exceptions.RunTimeNullPointerException;

public class State {

	public Translator translator;
	public UserDefinedVariableCollection variables = new UserDefinedVariableCollection();
	public UserDefinedCommandCollection commands = new UserDefinedCommandCollection();
	public Turtles turtles = new Turtles();
	
	public Map<String, WorkspaceVariable> variableMap;
	public Map<String,List<String>> userDefinedCommandMap;
	public static final WorkspaceVariable defaultVar = new WorkspaceVariable("dummyVar", 0);

	public State (Turtle someTurtle, Map<String,WorkspaceVariable> variables, Translator someTranslator) {
		userDefinedCommandMap = new HashMap<String,List<String>>();
		turtles.addTurtle(someTurtle);
		variableMap = variables;
		translator = someTranslator;
	}

	public WorkspaceVariable storeVariable(String name, double value){
		if(variableMap.containsKey(name)){
			variableMap.get(name).addValue(-variableMap.get(name).getMyValue()+value);
		}
		else{
			variableMap.put(name, new WorkspaceVariable(name, value));
		}
		return variableMap.get(name);
	}

	public void incrementVariable(String loopVariable, double incrementAmount) {
		variableMap.get(loopVariable).addValue(incrementAmount);
	}

	public double fetchVariable(String name) throws RunTimeNullPointerException{
		if(!variableMap.keySet().contains(name)){
			throw new RunTimeNullPointerException(name);
		}
		return variableMap.get(name).getMyValue(); 
	}

	public boolean variableExists(String name){
		return variableMap.containsKey(name);
	}

	public void storeUserDefinedCommand(String name, List<String> commands){
		userDefinedCommandMap.put(name, commands);
	}

	public List<String> fetchUserDefinedCommand(String name) throws RunTimeNullPointerException{
		if(!userDefinedCommandMap.keySet().contains(name)){
			throw new RunTimeNullPointerException(name);
		}
		return userDefinedCommandMap.get(name); 
	}
}

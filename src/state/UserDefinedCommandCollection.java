package state;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commandParsing.exceptions.RunTimeNullPointerException;

public class UserDefinedCommandCollection {
	private Map<String, Command> commandMap = new HashMap<String,Command>();
	
	public void storeUserDefinedCommand(String name, int numArgs, List<String> commands){
		commandMap.put(name, new Command(name, numArgs, commands));
	}

	public List<String> fetchUserDefinedCommand(String name) throws RunTimeNullPointerException{
		if(!commandMap.keySet().contains(name)){
			throw new RunTimeNullPointerException(name);
		}
		return commandMap.get(name).getCommands(); 
	}
	
	private class Command{
		private String name;
		private int numberOfArguments;
		private List<String> commandStrings;
		
		public Command(String aName, int numArgs, List<String> toDo){
			name = aName;
			numberOfArguments = numArgs;
			commandStrings = toDo;
		}
		
		public List<String> getCommands(){
			return commandStrings;
		}
		
		public int getNumArguments(){
			return numberOfArguments;
		}
		
		public String getName(){
			return name;
		}
	}
}

package workspace;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import commandParsing.exceptions.RunTimeNullPointerException;

public class UserDefinedCommandCollection {
	private Map<String, Command> commandMap = new HashMap<String,Command>();
	
	public void storeUserDefinedCommand(String name, int numArgs, List<String> commands, List<String> parameters){
		commandMap.put(name, new Command(name, numArgs, commands, parameters));
	}

	public Command fetchUserDefinedCommand(String name) throws RunTimeNullPointerException{
		if(!commandMap.keySet().contains(name)){
			throw new RunTimeNullPointerException(name);
		}
		return commandMap.get(name); 
	}
	
	public class Command{
		private String name;
		private int numberOfArguments;
		private List<String> commandStrings;
		private List<String> parameterList;
		
		public Command(String aName, int numArgs, List<String> toDo, List<String> parameters){
			name = aName;
			numberOfArguments = numArgs;
			commandStrings = toDo;
			parameterList = parameters;
		}
		
		public List<String> getCommands(){
			return commandStrings;
		}
		
		public Iterator<String> getCommandIterator(){
			return commandStrings.iterator();
		}
		
		public int getNumArguments(){
			return numberOfArguments;
		}
		
		public String getName(){
			return name;
		}
		
		public List<String> getParameters(){
			return parameterList;
		}
		@Override
		public boolean equals(Object o){
			if (!(o instanceof Command)){
				return false;
			}
			Command b = (Command) o;
			boolean commandStringsEqual = commandStrings.equals(b.commandStrings);
			boolean numArgsEqual = numberOfArguments == b.numberOfArguments;
			boolean namesEqual = name.equalsIgnoreCase(b.name);
			return commandStringsEqual && numArgsEqual && namesEqual;
		}
	}
}

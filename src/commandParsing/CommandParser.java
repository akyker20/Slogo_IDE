package commandParsing;

import java.util.Queue;

import stateUpdate.StateUpdate;

public abstract class CommandParser {
	
	private Queue<StateUpdate> updateQueue;
	private String[] commandString;
	
	public abstract void parse(String[] commandString, int parsePosition, Queue<StateUpdate> updateQueue);
	
	protected CommandParser createParser(String commandName){
		try {
			return (CommandParser) Class.forName(commandName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new NullCommandParser();
	}
	
	protected boolean isStringParsableAsFloat(String string){
		boolean isParseable = true;
		
		for(int i=0;i<string.length();i++){
			if(!Character.isDigit(string.charAt(i)) | string.charAt(i) == '.'){
				isParseable = false;
			}
		}
		
		return isParseable;
	}
	
	protected boolean isCommandString(String string){
		boolean isCommand = false;
		
		try {
			CommandParser parser = (CommandParser) Class.forName(string).newInstance();
			isCommand = true;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e){
			isCommand = false;
		}
		
		return isCommand;
	}
	
	protected abstract boolean isAppropriateCommandString(String string);
}

package commandParsing;

import java.util.Queue;

import stateUpdate.StateUpdate;

public abstract class CommandParser {
	
	private Queue<StateUpdate> updateQueue;
	private String[] commandString;
	
	public abstract void parse(String[] commandString, Queue<StateUpdate> updateQueue);
	
	public CommandParser createParser(String commandName){
		try {
			return (CommandParser) Class.forName(commandName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new NullCommandParser();
	}
}

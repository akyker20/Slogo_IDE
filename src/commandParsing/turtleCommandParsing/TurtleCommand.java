package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import stateUpdate.StateUpdate;

import commandParsing.CommandParser;
import commandParsing.mathCommandParsing.MathCommand;

public abstract class TurtleCommand extends CommandParser {
	
	public abstract void parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue);

	@Override
	protected boolean isAppropriateCommand(CommandParser command){
		boolean isCommand = false;
		
		try {
			MathCommand parser = (MathCommand) command;
			isCommand = true;
		} catch (ClassCastException e){
			isCommand = false;
		}
		
		return isCommand;
	}
}

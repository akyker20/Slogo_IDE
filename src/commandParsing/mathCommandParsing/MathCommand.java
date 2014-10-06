package commandParsing.mathCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import stateUpdate.ParseError;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;

public abstract class MathCommand extends CommandParser {
	
	@Override
	public abstract float parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue);

	@Override
	protected boolean isAppropriateCommand(CommandParser command) {
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

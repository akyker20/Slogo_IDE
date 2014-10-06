package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import stateUpdate.ParseError;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.mathCommandParsing.MathCommand;

public abstract class TurtleCommand extends CommandParser {

	public void parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue){
		accumulateFloatComponents(commandString, 1, updateQueue);
		if(errorOccured(updateQueue)){
			return;
		}
		else {
			generateUpdate(floatComponents.get(0), updateQueue);
		}
	}


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

	protected abstract void generateUpdate(float amount, Queue<StateUpdate> stateQueue);
}

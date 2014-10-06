package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import stateUpdate.ParseError;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.mathCommandParsing.MathCommand;



/**
 * Class parses String turtle commands into TurtleCommand objects
 *
 * @author steve, stanley
 *
 */

public abstract class TurtleCommand extends CommandParser {


	@Override
	public String parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue){
		accumulateFloatComponents(commandString, 1, updateQueue);
		if(errorOccured(updateQueue)){
			return "Compiletime error";
		}
		else {
			generateUpdate(expressionComponents.get(0), updateQueue);
			return expressionComponents.get(0);
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

	protected abstract void generateUpdate(String amount, Queue<StateUpdate> stateQueue);
}

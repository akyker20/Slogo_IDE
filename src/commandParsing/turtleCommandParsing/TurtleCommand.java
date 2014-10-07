package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import stateUpdate.ParseError;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.mathCommandParsing.MathCommand;



/**
 * Class parses String turtle commands into TurtleCommand objects
 *
 * @author steve, stanley
 *
 */

public abstract class TurtleCommand extends CommandParser {


	@Override
	public String parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue) throws CompileTimeParsingException{
		accumulateComponents(commandString, 1, updateQueue);
		if(errorOccured(updateQueue)){
			return "Compiletime error";
		}
		else {
			generateUpdate(expressionComponents.get(0), updateQueue);
			return expressionComponents.get(0);
		}
	}

	protected abstract void generateUpdate(String amount, Queue<StateUpdate> stateQueue);
}

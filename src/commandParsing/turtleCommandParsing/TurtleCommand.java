package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import stateUpdate.StateUpdate;
import commandParsing.FloatInputCommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;



/**
 * Class parses String turtle commands into TurtleCommand objects
 *
 * @author steve, stanley
 *
 */

public abstract class TurtleCommand extends FloatInputCommandParser {


	@Override
	protected String operateOnComponents(List<String> components, Queue<StateUpdate> updateQueue) throws RunTimeDivideByZeroException{
		generateUpdate(expressionComponents.get(0), updateQueue);
		return expressionComponents.get(0);
	}
	
	@Override
	protected int getNumberOfArguments() {
		return 1;
	}

	protected abstract void generateUpdate(String amount, Queue<StateUpdate> stateQueue);
}

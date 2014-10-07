package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;


/**
 * Class parses String structural commands into StructuralCommand objects
 *
 * @author steve, stanley
 *
 */
public abstract class StructuralCommand extends CommandParser {
	
	protected String generateQueueBetweenBraces(Iterator<String> commandString, Queue<StateUpdate> updateQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException{
		String stringOfInterest;
		String lastReturn;
		do{
			stringOfInterest = commandString.next();
			CommandParser commandParser = (CommandParser) createParser(stringOfInterest);
			lastReturn = commandParser.parse(commandString, updateQueue);
		} while (!stringOfInterest.equals("]"));
		
		return lastReturn;
	}
	

}

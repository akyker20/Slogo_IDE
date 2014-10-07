package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;

import drawableobject.DrawableObject;


/**
 * Class parses String structural commands into StructuralCommand objects
 *
 * @author steve, stanley
 *
 */
public abstract class StructuralCommand extends CommandParser {
	
	protected String generateQueueBetweenBraces(Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException{
		String stringOfInterest;
		String lastReturn;
		do{
			stringOfInterest = commandString.next();
			CommandParser commandParser = (CommandParser) createParser(stringOfInterest, state);
			lastReturn = commandParser.parse(commandString, objectQueue);
		} while (!stringOfInterest.equals("]"));
		
		return lastReturn;
	}
	

}

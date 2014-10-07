package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;


/**
 * Class parses String structural commands into StructuralCommand objects
 *
 * @author steve, stanley
 *
 */
public abstract class StructuralCommand extends CommandParser {
	
	protected float generateQueueBetweenBraces(Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException{
		String stringOfInterest;
		float lastReturn;
		do{
			stringOfInterest = commandString.next();
			CommandParser commandParser = (CommandParser) createParser(stringOfInterest, state);
			lastReturn = commandParser.parse(commandString, objectQueue);
		} while (!stringOfInterest.equals("]"));
		
		return lastReturn;
	}
	
	protected void ignoreUntilClosingBrace(Iterator<String> commandString){
		
	}
	
	private void findBrace(Iterator<String> commandString){
		String stringOfInterest = commandString.next();
		if(stringOfInterest.equals("]")){
			return;
		}
		else{
			if(stringOfInterest.equals("[")){
				findBrace(commandString);
			}
			else{
				
			}
		}
	}
	

}

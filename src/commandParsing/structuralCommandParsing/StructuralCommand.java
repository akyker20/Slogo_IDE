package commandParsing.structuralCommandParsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public abstract class StructuralCommand extends CommandParser {
	
	protected Iterator<String> enclosedCommands;
	protected double returnValue;

	protected void checkForOpeningBrace(Iterator<String> commandString) throws CompileTimeParsingException{
		String stringOfInterest = commandString.next();
		if(!stringOfInterest.equals("[")){
			throw new CompileTimeParsingException("expected opening brace");
		}
	}

	protected void extractCommandsBetweenBraces(Iterator<String> commandString) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException{
		List<String> commandList = new ArrayList<String>();
		
		String stringOfInterest = commandString.next();
		while (!stringOfInterest.equals("]") & commandString.hasNext()){
			commandList.add(stringOfInterest);
			stringOfInterest = commandString.next();
		} 
		
		if(!commandString.hasNext()){
			throw new CompileTimeParsingException("expected closing brace");
		}

		enclosedCommands = commandList.iterator();
	}
	
	protected void parseCommandsBetweenBraces(Iterator<String> commands, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException{
		double value = 0;
		while(commands.hasNext()){
			String stringOfInterest = commands.next();
			CommandParser parser = (CommandParser) createParser(stringOfInterest, state); 
			value = parser.parse(commands, objectQueue);
		}
		
		returnValue = value;
	}
	
	protected void setEnclosedCommandsToEmptyList(){
		enclosedCommands = Collections.<String>emptyList().iterator();
	}
	
	protected void ignoreUntilClosingBrace(Iterator<String> commandString) throws CompileTimeParsingException{
		findBrace(commandString);
		if(!commandString.hasNext()){
			throw new CompileTimeParsingException("expected closing brace");
		}
	}

	private void findBrace(Iterator<String> commandString){
		do{
			String stringOfInterest = commandString.next();
			if(stringOfInterest.equals("]")){
				return;
			}
			else if(stringOfInterest.equals("[")){
				findBrace(commandString);
			}
		}
		while (commandString.hasNext());
	}
}

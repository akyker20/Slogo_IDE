package commandParsing.userCommandParsing;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public class UserInstruction extends CommandParser {

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		// TODO Auto-generated method stub
		
		
		
		String commandName = commandString.next();
		List<String> commandStrings = state.commands.fetchUserDefinedCommand(commandName);
		while (commandStrings != null){
			commandStrings.
		}
//		state.fetchUserDefinedCommand(commandName)
		return 1;
		
	}

}

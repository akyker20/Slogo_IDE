package commandParsing.userCommandParsing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;
import commandParsing.structuralCommandParsing.StructuralCommand;
import drawableobject.DrawableObject;

public class MakeUserInstruction extends StructuralCommand {

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		String potentialCommandName = commandString.next();
		if(!isStringParsableAsCommand(potentialCommandName)){
			return 0;
		}
		extractCommandsBetweenBraces(commandString);
		for(String varName : enclosedCommands){
			if(!state.variableExists(varName)){
				state.storeVariable(varName, 0);
			}
		}
		extractCommandsBetweenBraces(commandString);
		try{
			Queue<DrawableObject> tempQueue = new LinkedList<DrawableObject>();
			parseCommandsBetweenBraces(enclosedCommands.iterator(), tempQueue);
		} catch (SLOGOException e) {
			return 0;
		}
		state.storeUserDefinedCommand(potentialCommandName, enclosedCommands);
		return 1;
	}
}
package commandParsing.userCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import state.State;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;
import commandParsing.structuralCommandParsing.StructuralCommand;

import drawableobject.DrawableObject;

public class MakeUserInstruction extends StructuralCommand {
	
	public MakeUserInstruction(State someState) {
		super(someState);
	}

	private List<String> parameters = new ArrayList<String>();

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

		Iterator<String> variableIterator = enclosedCommands.iterator();
		
		while (variableIterator.hasNext()){
			parameters.add(getVariable(variableIterator, objectQueue));
		}
		for(String varName : parameters){
			if(!state.variables.variableExists(varName)){
				state.variables.storeVariable(varName, 0);
			}
		}
		int numArgs = parameters.size();
		extractCommandsBetweenBraces(commandString);
		try{
			Queue<DrawableObject> tempQueue = new LinkedList<DrawableObject>();
			parseCommandsBetweenBraces(enclosedCommands.iterator(), tempQueue);
		} catch (SLOGOException e) {
			return 0;
		}
		state.commands.storeUserDefinedCommand(potentialCommandName, numArgs, enclosedCommands, parameters);
		return 1;
	}
}
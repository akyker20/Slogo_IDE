package commandParsing.variableCommandParsing;

import gui.variableslist.WorkspaceVariable;

import java.util.Iterator;
import java.util.Queue;

import state.State;

import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.VariableGenerator;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.structuralCommandParsing.StructuralCommand;

import drawableobject.DrawableObject;

public class MakeVariable extends StructuralCommand implements VariableGenerator {

	public MakeVariable(State someState) {
		super(someState);
	}

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		CommandParser commandParser = (CommandParser) createParser(commandString.next(), state);
		if(!(commandParser instanceof Variable)){
			throw new CompileTimeParsingException("expected variable name");
		}
		String variableName = commandString.next();
		if(!state.translator.matchesVariablePattern(variableName)){
			throw new CompileTimeParsingException("expected variable name: " + variableName);
		}
		accumulateComponents(commandString, 1, objectQueue);
		double amountToAssign = expressionComponents.get(0);
		WorkspaceVariable variable = state.variables.storeVariable(variableName, amountToAssign);
		objectQueue.add(generateDrawableObjectRepresentingVariable(variable));
		return amountToAssign;
	}

}

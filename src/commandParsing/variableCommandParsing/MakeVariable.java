package commandParsing.variableCommandParsing;

import gui.variableslist.WorkspaceVariable;
import java.util.Iterator;
import java.util.Queue;
import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.VariableGenerator;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.structuralCommandParsing.StructuralCommand;
import drawableobject.DrawableObject;

public class MakeVariable extends StructuralCommand implements VariableGenerator {

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
		if(!variableName.matches(state.getVariablePattern())){
			throw new CompileTimeParsingException("expected variable name: " + variableName);
		}
		accumulateComponents(commandString, 1, objectQueue);
		double amountToAssign = expressionComponents.get(0);
		WorkspaceVariable variable = state.storeVariable(variableName, amountToAssign);
		objectQueue.add(generateDrawableObjectRepresentingVariable(variable));
		return amountToAssign;
	}

}

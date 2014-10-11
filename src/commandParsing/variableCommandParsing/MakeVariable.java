package commandParsing.variableCommandParsing;

import java.util.Iterator;
import java.util.Queue;

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
		String variableName = commandString.next();
		if(!isStringParsableAsVariable(variableName)){
			throw new CompileTimeParsingException(variableName + " , expected variable name");
		}
		accumulateComponents(commandString, 1, objectQueue);
		double amountToAssign = expressionComponents.get(0);
		state.storeVariable(variableName, amountToAssign);
		objectQueue.add(generateDrawableObjectRepresentingVariable());
		return amountToAssign;
	}

}

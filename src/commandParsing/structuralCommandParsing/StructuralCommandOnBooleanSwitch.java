package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public abstract class StructuralCommandOnBooleanSwitch extends StructuralCommand {

	protected boolean booleanSwitch;
	
	protected void evaluateBooleanExpression(){
		booleanSwitch = expressionComponents.get(0) != 0;
	}

}

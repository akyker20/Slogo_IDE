package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import commandParsing.drawableObectGenerationInterfaces.VariableGenerator;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public abstract class RecurringCommand extends StructuralCommand implements VariableGenerator {
	
	protected String loopVariable;
	protected double incrementAmount;
	protected double loopVariableBound;

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		initializeLoopVariableParameters(commandString, objectQueue);
		extractCommandsBetweenBraces(commandString);
		
		while(loopVariableIsIncrementable()){
			parseCommandsBetweenBraces(enclosedCommands.iterator(), objectQueue);
			incrementLoopVariable();
		}
		return returnValue;
	}
	
	abstract protected void initializeLoopVariableParameters(Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException;
	
	protected void basicLoopVariableInitialization(Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException{
		accumulateComponents(commandString, 1, objectQueue);
		loopVariableBound = expressionComponents.get(0);
		incrementAmount = 1;
		state.storeVariable(loopVariable, 1);
	}
	
	protected void incrementLoopVariable(){
		state.incrementVariable(loopVariable, incrementAmount);
	}
	
	protected boolean loopVariableIsIncrementable() throws RunTimeNullPointerException{
		return loopVariableBound >= state.fetchVariable(loopVariable);
	}
}

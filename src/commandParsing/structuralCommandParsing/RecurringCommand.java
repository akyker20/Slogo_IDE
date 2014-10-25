package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.drawableObectGenerationInterfaces.VariableGenerator;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public abstract class RecurringCommand extends StructuralCommand implements VariableGenerator {

	public RecurringCommand(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	protected String loopVariable;
	protected double incrementAmount;
	protected double loopVariableBound;

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		initializeLoopVariableParameters(commandString, objectQueue);
		extractCommandsBetweenBraces(commandString);

		while (loopVariableIsIncrementable()) {
			parseCommandsBetweenBraces(enclosedCommands.iterator(), objectQueue);
			incrementLoopVariable();
		}
		return returnValue;
	}

	abstract protected void initializeLoopVariableParameters(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue) throws SLOGOException;

	protected void basicLoopVariableInitialization(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue) throws SLOGOException {
		accumulateComponents(commandString, 1, objectQueue);
		loopVariableBound = expressionComponents.get(0);
		incrementAmount = 1;
		workspace.variables.storeVariable(loopVariable, 1);
	}

	protected void incrementLoopVariable() {
		workspace.variables.incrementVariable(loopVariable, incrementAmount);
	}

	protected boolean loopVariableIsIncrementable() throws RunTimeNullPointerException {
		return loopVariableBound >= workspace.variables.fetchVariable(loopVariable);
	}
}

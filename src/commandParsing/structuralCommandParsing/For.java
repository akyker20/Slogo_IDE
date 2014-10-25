package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class For extends RecurringCommand {

	public For(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected void initializeLoopVariableParameters(Iterator<String> commandStringIterator,
			Queue<DrawableObject> objectQueue) throws SLOGOException {
		checkForOpeningBrace(commandStringIterator);
		loopVariable = getVariable(commandStringIterator, objectQueue);
		try {
			if (!workspace.translator.matchesVariablePattern(loopVariable)) {
				throw new CompileTimeParsingException("expected variable name: " + loopVariable);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		accumulateComponents(commandStringIterator, 3, objectQueue);
		double start = expressionComponents.get(0);
		loopVariableBound = expressionComponents.get(1);
		incrementAmount = expressionComponents.get(2);
		workspace.variables.storeVariable(loopVariable, start);
		checkForClosingBrace(commandStringIterator);
	}
}

package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.drawableObectGenerationInterfaces.UserDefinedVariableGenerator;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

/**
 * This specifically parses any kind of recurring command such as for, doTimes, and repeat.
 * 
 * @author Steve Kuznetsov
 *
 */

public abstract class RecurringCommand extends StructuralCommand implements
UserDefinedVariableGenerator {

    public RecurringCommand (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    protected String loopVariable;
    protected double incrementAmount;
    protected double loopVariableBound;

    @Override
    public double parse (Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
            throws SLOGOException {
        initializeLoopVariableParameters(commandStringIterator, objectQueue);
        extractCommandsBetweenBraces(commandStringIterator);

        while (loopVariableIsIncrementable()) {
            parseCommandsBetweenBraces(enclosedCommands.iterator(), objectQueue);
            incrementLoopVariable(objectQueue);
        }
        return returnValue;
    }

    abstract protected void initializeLoopVariableParameters (Iterator<String> commandStringIterator,
                                                              Queue<DrawableObject> objectQueue)
                                                                      throws SLOGOException;

    protected void basicLoopVariableInitialization (Iterator<String> commandStringIterator,
                                                    Queue<DrawableObject> objectQueue)
                                                            throws SLOGOException {
        accumulateComponents(commandStringIterator, 1, objectQueue);
        loopVariableBound = expressionComponents.get(0);
        incrementAmount = 1;
        workspace.variables.storeVariable(loopVariable, 1);
        objectQueue.add(generateDrawableObjectRepresentingVariable(workspace.variables
                                                                   .fetchWorkspaceVariable(loopVariable)));
    }

    protected void incrementLoopVariable (Queue<DrawableObject> objectQueue)
            throws RunTimeNullPointerException {
        workspace.variables.incrementVariable(loopVariable, incrementAmount);
        objectQueue.add(generateDrawableObjectRepresentingVariable(workspace.variables
                                                                   .fetchWorkspaceVariable(loopVariable)));
    }

    protected boolean loopVariableIsIncrementable () throws RunTimeNullPointerException {
        return loopVariableBound >= workspace.variables.fetchVariable(loopVariable);
    }
}

package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class DoTimes extends RecurringCommand {

    public DoTimes (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    protected void initializeLoopVariableParameters (Iterator<String> commandStringIterator,
                                                     Queue<DrawableObject> objectQueue)
                                                             throws SLOGOException {
        checkForOpeningBrace(commandStringIterator);
        loopVariable = getVariable(commandStringIterator, objectQueue);
        if (!workspace.translator.matchesVariablePattern(loopVariable)) { throw new CompileTimeParsingException(
                                                                                                                "expected variable name: " +
                                                                                                                        loopVariable); }
        basicLoopVariableInitialization(commandStringIterator, objectQueue);
        checkForClosingBrace(commandStringIterator);
    }
}

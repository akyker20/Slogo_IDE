package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class IfElse extends StructuralCommandOnBooleanSwitch {

    public IfElse (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    public double parse (Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
            throws SLOGOException {

        accumulateComponents(commandStringIterator, 1, objectQueue);
        evaluateBooleanExpression();

        if (booleanSwitch) {
            extractCommandsBetweenBraces(commandStringIterator);
            ignoreUntilClosingBrace(commandStringIterator);
        }
        else {
            ignoreUntilClosingBrace(commandStringIterator);
            extractCommandsBetweenBraces(commandStringIterator);
        }

        parseCommandsBetweenBraces(enclosedCommands.iterator(), objectQueue);

        return returnValue;
    }

}

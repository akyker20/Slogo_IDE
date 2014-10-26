package commandParsing.variableCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

/**
 * This class is the Variable class that contains the information for parsing each Variable.
 * 
 * @author Stanley Yuan, Steve Kuznetsov
 *
 */

public class Variable extends CommandParser {

    public Variable (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    private String variableName;

    @Override
    public double parse (Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
            throws SLOGOException {

        variableName = commandStringIterator.next();
        return workspace.variables.fetchVariable(variableName);
    }

    public String getVariableName () {
        return variableName;
    }

}

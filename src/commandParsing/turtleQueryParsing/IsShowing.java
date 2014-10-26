package commandParsing.turtleQueryParsing;

import java.util.Iterator;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class IsShowing extends CommandParser {

    public IsShowing (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    public double parse (Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
            throws SLOGOException {
        return workspace.turtles.getLastActiveTurtle().isTurtleShowing() ? 1 : 0;
    }

}

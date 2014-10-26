package commandParsing.turtleQueryParsing;

import java.util.Iterator;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class Turtles extends CommandParser {

    public Turtles (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    public double parse (Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
            throws SLOGOException {
        return workspace.turtles.getActiveTurtles().size();
    }

}

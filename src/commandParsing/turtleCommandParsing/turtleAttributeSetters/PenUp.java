package commandParsing.turtleCommandParsing.turtleAttributeSetters;

import java.util.Iterator;
import java.util.Queue;
import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class PenUp extends CommandParser {

    public PenUp (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    public double parse (Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
            throws SLOGOException {
        for (Turtle t : workspace.turtles.getActiveTurtles()) {
            t.pen.togglePenUp();
        }
        return 0;
    }

}

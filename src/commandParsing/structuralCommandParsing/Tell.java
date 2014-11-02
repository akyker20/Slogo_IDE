package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

//This entire file is part of my masterpiece.
//Stanley Yuan

public class Tell extends MultipleTurtleCommand {

    public Tell (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    public double parse (Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
            throws SLOGOException {

        workspace.turtles.clearActiveTurtles();
        double lastTurtleID = 0;
        extractCommandsBetweenBraces(commandStringIterator);
        determineTurtlesToActivate(enclosedCommands.iterator(), objectQueue);

        makeAndActivateGivenTurtles(objectQueue);

        return lastTurtleID;
    }

}

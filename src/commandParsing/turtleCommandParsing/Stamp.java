package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class Stamp extends CommandParser implements TurtleGenerator {

    public Stamp (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    public double parse (Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
            throws SLOGOException {
        double turtleStampIndex = 0;
        for (Turtle t : workspace.turtles.getActiveTurtles()) {
            Turtle stamp = new Turtle(t);
            workspace.turtles.addStamp(stamp);
            objectQueue.add(generateDrawableObjectRepresentingTurtle(stamp));
            turtleStampIndex = t.getID();
        }
        return turtleStampIndex;
    }
}

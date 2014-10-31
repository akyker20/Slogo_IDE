package commandParsing;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

//This entire file is part of my masterpiece.
//Steve Kuznetsov

/**
 * This is the broad CommandParser class, the superclass for every parser class.
 * 
 * @author Steve Kuznetsov
 *
 */

public abstract class CommandParser {

    protected static WorkspaceState workspace;
    protected List<Double> expressionComponents = new ArrayList<Double>();

    public CommandParser (WorkspaceState someWorkspace) {
        workspace = someWorkspace;
    }

    public abstract double parse (Iterator<String> commandStringIterator,
                                  Queue<DrawableObject> objectQueue)
                                          throws SLOGOException;

    protected void accumulateComponents (Iterator<String> commandStringIterator,
                                         int numberToAccumulate,
                                         Queue<DrawableObject> objectQueue) throws SLOGOException {
        expressionComponents.clear();
        while (expressionComponents.size() < numberToAccumulate) {
            if (!commandStringIterator.hasNext()) { throw new CompileTimeParsingException(
                                                                                          "Ran out of bounds looking for next component"); }
            String stringOfInterest = commandStringIterator.next();

            if (isStringParsableAsCommand(stringOfInterest)) {
                CommandParser commandParser = createParser(stringOfInterest, workspace);
                expressionComponents.add(commandParser.parse(commandStringIterator, objectQueue));
            }
            else {
                objectQueue.clear();
                throw new CompileTimeParsingException(stringOfInterest);
            }
        }
    }

    protected boolean isStringParsableAsCommand (String string) {
        String[] parts = string.split("\\.");
        return workspace.translator.matchesCommandPattern(parts[parts.length - 1]);
    }

    public static CommandParser createParser (String commandName, WorkspaceState workspace)
            throws CompileTimeParsingException {
        try {
            return (CommandParser) Class.forName(commandName).getConstructor(WorkspaceState.class)
                    .newInstance(workspace);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException
                | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            throw new CompileTimeParsingException(commandName);
        }
    }
}

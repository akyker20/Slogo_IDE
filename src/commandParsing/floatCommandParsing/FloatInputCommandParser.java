package commandParsing.floatCommandParsing;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

//This entire file is part of my masterpiece.
//Steve Kuznetsov

/**
 * This parses anything that you input either one or two floats.
 * 
 * @author Stanley Yuan, Steve Kuznetsov
 *
 */

public abstract class FloatInputCommandParser extends CommandParser {

    public FloatInputCommandParser (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    public double parse (Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
            throws SLOGOException {
        accumulateComponents(commandStringIterator, getNumberOfArguments(), objectQueue);
        return operateOnComponents(expressionComponents, objectQueue);
    }

    protected abstract int getNumberOfArguments ();

    protected abstract double operateOnComponents (List<Double> components,
                                                   Queue<DrawableObject> objectQueue)
                                                           throws RunTimeDivideByZeroException;

}

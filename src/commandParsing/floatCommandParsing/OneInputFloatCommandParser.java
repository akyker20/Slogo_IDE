package commandParsing.floatCommandParsing;

import java.util.List;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import drawableobject.DrawableObject;

//This entire file is part of my masterpiece.
//Steve Kuznetsov

/**
 * This parses commands that require a single float input.
 * 
 * @author Stanley Yuan, Steve Kuznetsov
 *
 */

public abstract class OneInputFloatCommandParser extends FloatInputCommandParser {

    public OneInputFloatCommandParser (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    protected int getNumberOfArguments () {
        return 1;
    }

    @Override
    protected abstract double operateOnComponents (List<Double> components,
                                                   Queue<DrawableObject> objectQueue)
                                                           throws RunTimeDivideByZeroException;

}

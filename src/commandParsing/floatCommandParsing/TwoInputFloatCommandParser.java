package commandParsing.floatCommandParsing;

import java.util.List;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import drawableobject.DrawableObject;


public abstract class TwoInputFloatCommandParser extends FloatInputCommandParser {

    public TwoInputFloatCommandParser (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    protected int getNumberOfArguments () {
        return 2;
    }

    @Override
    protected abstract double operateOnComponents (List<Double> components,
                                                   Queue<DrawableObject> objectQueue)
                                                           throws RunTimeDivideByZeroException;

}

package commandParsing.booleanCommandParsing;

import java.util.List;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.TwoInputFloatCommandParser;
import drawableobject.DrawableObject;


public class Or extends TwoInputFloatCommandParser {

    public Or (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    protected double operateOnComponents (List<Double> components, Queue<DrawableObject> objectQueue)
            throws RunTimeDivideByZeroException {
        return components.get(0) != 0 || components.get(1) != 0 ? 1 : 0;
    }

}

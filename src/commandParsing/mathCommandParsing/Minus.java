package commandParsing.mathCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import stateUpdate.StateUpdate;


public class Minus extends MathCommand {

    @Override
    public float parse (Iterator<String> commandString, Queue<StateUpdate> updateQueue) {
        generateComponents(commandString, updateQueue);
        if (errorOccured(updateQueue)) {
            return Float.NEGATIVE_INFINITY;
        }
        else {
            return components.get(0) - components.get(1);
        }
    }

}

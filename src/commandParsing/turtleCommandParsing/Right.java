package commandParsing.turtleCommandParsing;

import java.util.Queue;
import stateUpdate.Rotate;
import stateUpdate.StateUpdate;


public class Right extends TurtleCommand {

    @Override
    protected void generateUpdate (String amount, Queue<StateUpdate> stateQueue) {
        stateQueue.add(new Rotate(amount));
    }

}

package commandParsing.turtleCommandParsing;

import java.util.Queue;
import stateUpdate.Move;
import stateUpdate.StateUpdate;


public class Backward extends TurtleCommand {

    @Override
    protected void generateUpdate (float amount, Queue<StateUpdate> stateQueue) {
        stateQueue.add(new Move(-amount));
    }

}

package commandParsing.turtleCommandParsing;

import java.util.Queue;
import stateUpdate.Move;
import stateUpdate.StateUpdate;


public class Forward extends TurtleCommand {

    @Override
    public void generateUpdate (String distance, Queue<StateUpdate> stateQueue) {
        stateQueue.add(new Move(distance));
    }

}

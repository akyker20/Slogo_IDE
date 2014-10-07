package commandParsing.turtleCommandParsing;

import java.util.Queue;

import stateUpdate.Move;
import drawableobject.DrawableObject;


public class Backward extends TurtleCommand {

    @Override
    protected void generateUpdate (float amount, Queue<DrawableObject> objectQueue) {
    	state.moveBackward(amount);
        objectQueue.add(new DrawableObject());
    }

}

package commandParsing.turtleCommandParsing;

import java.util.Queue;

import stateUpdate.Rotate;
import drawableobject.DrawableObject;


public class Right extends TurtleCommand {

    @Override
    protected void generateUpdate (float amount, Queue<DrawableObject> objectQueue) {
    	state.rotateRight(amount);
        objectQueue.add(new DrawableObject());
    }

}

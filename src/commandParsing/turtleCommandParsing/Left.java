package commandParsing.turtleCommandParsing;

import java.util.Queue;

import stateUpdate.Rotate;
import drawableobject.DrawableObject;


public class Left extends TurtleCommand {

    @Override
    protected void generateUpdate (float amount, Queue<DrawableObject> objectQueue) {
    	state.rotateLeft(amount);
        objectQueue.add(new DrawableObject());
    }

}

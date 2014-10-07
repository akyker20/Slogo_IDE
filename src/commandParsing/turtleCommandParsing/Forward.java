package commandParsing.turtleCommandParsing;

import java.util.Queue;

import stateUpdate.Move;
import drawableobject.DrawableObject;


public class Forward extends TurtleCommand {

    @Override
    public void generateUpdate (float amount, Queue<DrawableObject> objectQueue) {
    	state.moveForward(amount);
        objectQueue.add(new DrawableObject());
    }

}

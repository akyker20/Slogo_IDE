package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import stateUpdate.Move;
import stateUpdate.ParseError;
import stateUpdate.StateUpdate;

import commandParsing.mathCommandParsing.MathCommand;

public class Forward extends TurtleCommand {
	
	public void generateUpdate(float distance, Queue<StateUpdate> stateQueue){
		stateQueue.add(new Move(distance));
	}

}

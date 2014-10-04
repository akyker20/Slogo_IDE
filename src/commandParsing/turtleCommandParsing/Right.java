package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import stateUpdate.StateUpdate;

public class Right extends TurtleCommand {

	String commandName;
	double amount;
	
	@Override
	public void parse(Iterator<String> commandStrings, Queue<StateUpdate> stateQueue) {
	}

}

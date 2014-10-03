package commandParsing.turtleCommandParsing;

import java.util.Queue;

import commandParsing.CommandParser;
import stateUpdate.StateUpdate;

public class Right extends TurtleCommand {

	String commandName;
	double amount;
	
	@Override
	public void parse(String[] commandStrings, int parsePosition, Queue<StateUpdate> stateQueue) {
	}

}

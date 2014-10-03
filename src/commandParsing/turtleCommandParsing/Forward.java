package commandParsing.turtleCommandParsing;

import java.util.Queue;

import commandParsing.CommandParser;
import stateUpdate.StateUpdate;

public class Forward extends TurtleCommand {

	float distance;
	
	@Override
	public void parse(String[] commandStrings, int parsePosition, Queue<StateUpdate> stateQueue) {
		String stringOfInterest = commandStrings[parsePosition];
		
		

	}

}

package commandParsing;

import java.util.Iterator;
import java.util.Queue;

import stateUpdate.StateUpdate;

public class NullCommandParser extends CommandParser {

	@Override
	protected boolean isAppropriateCommand(CommandParser command) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float parse(Iterator<String> commandString,
			Queue<StateUpdate> updateQueue) {
		// TODO Auto-generated method stub
		return Float.NEGATIVE_INFINITY;
	}


}

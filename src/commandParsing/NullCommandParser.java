package commandParsing;

import java.util.Iterator;
import java.util.Queue;

import stateUpdate.StateUpdate;

public class NullCommandParser extends CommandParser {

	@Override
	public String parse(Iterator<String> commandString,	Queue<StateUpdate> updateQueue) {
		return "";
	}
}

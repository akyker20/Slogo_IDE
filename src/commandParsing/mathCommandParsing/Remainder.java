package commandParsing.mathCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import stateUpdate.StateUpdate;


public class Remainder extends MathCommand {

	@Override
	public float parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue) {
		accumulateFloatComponents(commandString, 2, updateQueue);
		if(errorOccured(updateQueue)){
			return Float.NEGATIVE_INFINITY;
		}
		else {
			return floatComponents.get(0) % floatComponents.get(1);
		}
	}

}

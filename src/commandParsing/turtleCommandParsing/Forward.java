package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import stateUpdate.Move;
import stateUpdate.ParseError;
import stateUpdate.StateUpdate;

import commandParsing.mathCommandParsing.MathCommand;

public class Forward extends TurtleCommand {

	float distance;
	
	@Override
	public void parse(Iterator<String> commandStrings, Queue<StateUpdate> stateQueue) {
		String stringOfInterest = commandStrings.next();
		
		if(isCommandString(stringOfInterest)){
			if(isAppropriateCommand(createParser(stringOfInterest))){
				MathCommand command = (MathCommand) createParser(stringOfInterest);
				distance = command.parse(commandStrings, stateQueue);
				generateUpdate(distance, stateQueue);
			}
			else{
				stateQueue.clear();
				stateQueue.add(new ParseError());
			}
		}
		else{
			if(isStringParsableAsFloat(stringOfInterest)){
				distance = Float.parseFloat(stringOfInterest);
				generateUpdate(distance, stateQueue);
			}
		}
	}
	
	public void generateUpdate(float distance, Queue<StateUpdate> stateQueue){
		stateQueue.add(new Move(distance));
	}

}

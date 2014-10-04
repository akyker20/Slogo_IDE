package commandParsing.mathCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import stateUpdate.ParseError;
import stateUpdate.StateUpdate;

public class Sum extends MathCommand {

	List<Float> sumComponents = new ArrayList<Float>();
	float resultOfSum;

	@Override
	public float parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue) {

		while(sumComponents.size()<2){
			String stringOfInterest = commandString.next();

			if(isCommandString(stringOfInterest)){
				if(isAppropriateCommand(createParser(stringOfInterest))){
					MathCommand command = (MathCommand) createParser(stringOfInterest);
					sumComponents.add(command.parse(commandString, updateQueue));
					if(errorOccured(updateQueue)){
						return (float) 0;
					}
				}
				else{
					updateQueue.clear();
					updateQueue.add(new ParseError());
					return (float) 0;
				}
			}
			else{
				if(isStringParsableAsFloat(stringOfInterest)){
					sumComponents.add(Float.parseFloat(stringOfInterest));

				}
			}
		}
		
		return sumComponents.get(0) + sumComponents.get(1);
	}

}

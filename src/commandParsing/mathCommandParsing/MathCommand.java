package commandParsing.mathCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import stateUpdate.ParseError;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;



/**
 * Class parses String math commands into MathCommand objects
 *
 * @author steve, stanley
 *
 */
public abstract class MathCommand extends CommandParser {
	
	@Override
	public String parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue) {
		accumulateFloatComponents(commandString, 2, updateQueue);
		if(errorOccured(updateQueue)){
			return "Compiletime Error";
		}
		else {
			String a = expressionComponents.get(0);
			String b = expressionComponents.get(1);
			if (isStringParsableAsFloat(a) & isStringParsableAsFloat(b)){
				return Float.toString(returnFloat(a,b));
			}
			else {
				return returnString(a,b);
			}		
		}
	}

	@Override
	protected boolean isAppropriateCommand(CommandParser command) {
		boolean isCommand = false;
		
		try {
			MathCommand parser = (MathCommand) command;
			isCommand = true;
		} catch (ClassCastException e){
			isCommand = false;
		}
		
		return isCommand;
	}
	
	protected abstract float returnFloat(String a, String b);
	
	protected abstract String returnString(String a, String b);
}

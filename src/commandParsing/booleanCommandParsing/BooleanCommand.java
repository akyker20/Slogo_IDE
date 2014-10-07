package commandParsing.booleanCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;

public abstract class BooleanCommand extends CommandParser {

	@Override
	public String parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue) throws CompileTimeParsingException {
		accumulateComponents(commandString, 2, updateQueue);
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

	protected abstract float returnFloat(String a, String b);
	
	protected abstract String returnString(String a, String b);

}

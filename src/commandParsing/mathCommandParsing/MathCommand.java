package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import stateUpdate.StateUpdate;

import commandParsing.FloatInputCommandParser;
import commandParsing.exceptions.RunTimeDivideByZeroException;



/**
 * Class parses String math commands into MathCommand objects
 *
 * @author steve, stanley
 *
 */
public abstract class MathCommand extends FloatInputCommandParser {

	protected static final int NUMBER_OF_ARGUMENTS = 2;

	@Override
	protected String operateOnComponents(List<String> components, Queue<StateUpdate> upateQueue) throws RunTimeDivideByZeroException{
		String a = expressionComponents.get(0);
		String b = expressionComponents.get(1);
		if (isStringParsableAsFloat(a) & isStringParsableAsFloat(b)){
			return Float.toString(returnFloat(a,b));
		}
		else {
			return returnString(a,b);
		}
	}
	
	@Override
	protected int getNumberOfArguments(){
		return 2;
	}
	
	protected abstract float returnFloat(String a, String b) throws RunTimeDivideByZeroException;

	protected abstract String returnString(String a, String b);
}

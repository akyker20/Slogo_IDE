package commandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import stateUpdate.ParseError;
import stateUpdate.StateUpdate;


/**
 * Class parses String commands into CommandParser objects
 *
 * @author steven, stanley
 *
 */
public abstract class CommandParser {

	protected List<String> expressionComponents = new ArrayList<String>();
	
	public abstract String parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue);

	protected void accumulateFloatComponents(Iterator<String> commandString, int numberToAccumulate, Queue<StateUpdate> updateQueue){
		expressionComponents.clear();
		while(expressionComponents.size()<numberToAccumulate){
			String stringOfInterest = commandString.next();

			if(isCommandString(stringOfInterest)){
				CommandParser commandParser = (CommandParser) createParser(stringOfInterest);
				expressionComponents.add(commandParser.parse(commandString, updateQueue));
				if(errorOccured(updateQueue)){
					return;
				}

			}
			else if(stringRepresentsNumber(stringOfInterest)){
				expressionComponents.add(stringOfInterest);
			}
			else{ // not a command, not a number, compile-time error
				updateQueue.clear();
				updateQueue.add(new ParseError());
				return;
			}
		}

	}
	
	protected boolean stringRepresentsNumber(String string){
		return isStringParsableAsFloat(string) | isStringParsableAsVariable(string);
	}
	
	private boolean isStringParsableAsVariable(String string) {
		return string.charAt(0)==':';
	}

	protected boolean isStringParsableAsFloat(String string){
		boolean isParseable = true;

		for(int i=0;i<string.length();i++){
			if(!Character.isDigit(string.charAt(i)) & string.charAt(i) != '.'){
				isParseable = false;
			}
		}

		return isParseable;
	}

	protected boolean isCommandString(String string){
		CommandParser parser = createParser(string);
		
		return !(parser instanceof NullCommandParser);
	}

	public static CommandParser createParser(String commandName){
		try {
			return (CommandParser) Class.forName(commandName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			//e.printStackTrace();
			return new NullCommandParser();
		}
	}

	protected abstract boolean isAppropriateCommand(CommandParser command);

	protected boolean errorOccured(Queue<StateUpdate> queue){
		return queue.contains(new ParseError());
	}

}

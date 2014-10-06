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

	protected List<Float> floatComponents = new ArrayList<Float>();
	
	public abstract float parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue);

	protected void accumulateFloatComponents(Iterator<String> commandString, int numberToAccumulate, Queue<StateUpdate> updateQueue){
		floatComponents.clear();
		while(floatComponents.size()<numberToAccumulate){
			String stringOfInterest = commandString.next();

			if(isCommandString(stringOfInterest)){
				CommandParser commandParser = (CommandParser) createParser(stringOfInterest);
				floatComponents.add(commandParser.parse(commandString, updateQueue));
				if(errorOccured(updateQueue)){
					return;
				}

			}
			else if(isStringParsableAsFloat(stringOfInterest)){
				floatComponents.add(Float.parseFloat(stringOfInterest));
			}
			else{ // not a command, not a number, compile-time error
				updateQueue.clear();
				updateQueue.add(new ParseError());
				return;
			}
		}

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

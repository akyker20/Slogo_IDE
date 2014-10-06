package commandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import commandParsing.mathCommandParsing.MathCommand;

import stateUpdate.ParseError;
import stateUpdate.StateUpdate;

public abstract class CommandParser {
	
	private Queue<StateUpdate> updateQueue;
	private String[] commandString;	
	protected List<Float> floatComponents = new ArrayList<Float>();
	
	public static CommandParser createParser(String commandName){
		try {
			return (CommandParser) Class.forName(commandName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return new NullCommandParser();
	}
	
	protected void accumulateFloatComponents(Iterator<String> commandString, int numberToAccumulate, Queue<StateUpdate> updateQueue){
		floatComponents.clear();
		while(floatComponents.size()<numberToAccumulate){
			String stringOfInterest = commandString.next();

			if(isCommandString(stringOfInterest)){
				if(isAppropriateCommand(createParser(stringOfInterest))){
					MathCommand command = (MathCommand) createParser(stringOfInterest);
					floatComponents.add(command.parse(commandString, updateQueue));
					if(errorOccured(updateQueue)){
						return;
					}
				}
				else{
					updateQueue.clear();
					updateQueue.add(new ParseError());
					return;
				}
			}
			else{
				if(isStringParsableAsFloat(stringOfInterest)){
					floatComponents.add(Float.parseFloat(stringOfInterest));
				}
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
		boolean isCommand = false;
		
		try {
			CommandParser parser = (CommandParser) Class.forName(string).newInstance();
			isCommand = true;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e){
			isCommand = false;
		}
		
		return isCommand;
	}
	
	protected abstract boolean isAppropriateCommand(CommandParser command);
	
	protected boolean errorOccured(Queue<StateUpdate> queue){
		return queue.contains(new ParseError());
	}
}

package commandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import stateUpdate.State;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public abstract class CommandParser {
	
	protected static State state;
	protected List<Float> expressionComponents = new ArrayList<Float>();
	
	public void setState(State someState){
		state = someState;
	}
	
	public abstract float parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException;
	
	protected void accumulateComponents(Iterator<String> commandString, int numberToAccumulate, Queue<DrawableObject> objectQueue)  throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException{
		expressionComponents.clear();
		while(expressionComponents.size()<numberToAccumulate){
			String stringOfInterest = commandString.next();

			if(isCommandString(stringOfInterest)){
				CommandParser commandParser = (CommandParser) createParser(stringOfInterest, state);
				expressionComponents.add(commandParser.parse(commandString, objectQueue));
			}
			else if(stringRepresentsNumber(stringOfInterest)){
				expressionComponents.add(decodeStringToNumber(stringOfInterest));
			}
			else{ // not a command, not a number, compile-time error
				objectQueue.clear();
				throw new CompileTimeParsingException(stringOfInterest);
			}
		}
	}
	
	private Float decodeStringToNumber(String stringOfInterest) throws RunTimeNullPointerException {
		if(isStringParsableAsFloat(stringOfInterest)){
			return Float.parseFloat(stringOfInterest);
		}
		else{
			return state.fetchVariable(stringOfInterest);
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
		int numDelimiters = 0;
		for(int i=0;i<string.length();i++){
			if(string.charAt(i)=='.'){
				numDelimiters++;
			}
			if(!Character.isDigit(string.charAt(i)) & string.charAt(i) != '.'){
				isParseable = false;
			}
		}
		if(numDelimiters>1){
			isParseable = false;
		}
		return isParseable;
	}

	protected boolean isCommandString(String string){
		CommandParser parser = createParser(string, state);
		return !(parser instanceof NullCommandParser);
	}

	public static CommandParser createParser(String commandName, State state){
		try {
			CommandParser parser = (CommandParser) Class.forName(commandName).newInstance();
			parser.setState(state);
			return parser;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			return new NullCommandParser();
		}
	}
}

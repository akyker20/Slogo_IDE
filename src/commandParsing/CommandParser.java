package commandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import state.State;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public abstract class CommandParser {
	
	protected static State state;
	protected List<Double> expressionComponents = new ArrayList<Double>();
	
	public void setState(State someState){
		state = someState;
	}
	
	public abstract double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException;
	
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
	
	private Double decodeStringToNumber(String stringOfInterest) throws RunTimeNullPointerException {
		if(isStringParsableAsFloat(stringOfInterest)){
			return Double.parseDouble(stringOfInterest);
		}
		else{
			return state.fetchVariable(stringOfInterest);
		}
	}

	protected boolean stringRepresentsNumber(String string){
		return isStringParsableAsFloat(string) | isStringParsableAsVariable(string);
	}
	
	protected boolean isStringParsableAsVariable(String string) {
		return string.matches(state.getVariablePattern());
	}

	protected boolean isStringParsableAsFloat(String string){
		return string.matches(state.getConstantPattern());
	}

	protected boolean isCommandString(String string){
		String[] parts = string.split("\\.");
		return parts[parts.length-1].matches(state.getCommandPattern());
	}

	public static CommandParser createParser(String commandName, State state) throws CompileTimeParsingException{
		try {
			CommandParser parser = (CommandParser) Class.forName(commandName).newInstance();
			parser.setState(state);
			return parser;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new CompileTimeParsingException(commandName);
		}
	}
}

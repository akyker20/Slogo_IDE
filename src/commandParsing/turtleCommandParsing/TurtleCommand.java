package commandParsing.turtleCommandParsing;

import commandParsing.CommandParser;
import commandParsing.mathCommandParsing.MathCommand;

public abstract class TurtleCommand extends CommandParser {

	@Override
	protected boolean isAppropriateCommand(CommandParser command){
		boolean isCommand = false;
		
		try {
			CommandParser parser = (MathCommand) command;
			isCommand = true;
		} catch (ClassCastException e){
			isCommand = false;
		}
		
		return isCommand;
	}
}

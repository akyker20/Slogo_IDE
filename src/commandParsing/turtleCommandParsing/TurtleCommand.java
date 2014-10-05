package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import stateUpdate.ParseError;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.mathCommandParsing.MathCommand;


public abstract class TurtleCommand extends CommandParser {

    private float amount;

    public void parse (Iterator<String> commandString, Queue<StateUpdate> updateQueue) {
        String stringOfInterest = commandString.next();

        if (isCommandString(stringOfInterest)) {
            if (isAppropriateCommand(createParser(stringOfInterest))) {
                MathCommand command = (MathCommand) createParser(stringOfInterest);
                amount = command.parse(commandString, updateQueue);
                if (errorOccured(updateQueue)) { return; }
                generateUpdate(amount, updateQueue);
            }
            else {
                updateQueue.clear();
                updateQueue.add(new ParseError());
                return;
            }
        }
        else {
            if (isStringParsableAsFloat(stringOfInterest)) {
                amount = Float.parseFloat(stringOfInterest);
                generateUpdate(amount, updateQueue);
            }
        }
    }

    @Override
    protected boolean isAppropriateCommand (CommandParser command) {
        boolean isCommand = false;

        try {
            isCommand = true;
        }
        catch (ClassCastException e) {
            isCommand = false;
        }

        return isCommand;
    }

    protected abstract void generateUpdate (float amount, Queue<StateUpdate> stateQueue);
}

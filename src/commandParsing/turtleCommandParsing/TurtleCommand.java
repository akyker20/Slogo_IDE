package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import stateUpdate.ParseError;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.mathCommandParsing.MathCommand;



/**
 * Class parses String turtle commands into TurtleCommand objects
 *
 * @author steve, stanley
 *
 */

public abstract class TurtleCommand extends CommandParser {

    private float amount;


    /**
     * Method parses Turtle command strings and adds StateUpdate objects to the StateUpdate queue
     *
     * @param commandString
     * @param updateQueue
     */

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


    /**
     * Method generates a turtle object in form of a StateUpdate object and adds it to the
     * StateUpdate queue
     *
     * @param amount
     * @param stateQueue
     */

    protected abstract void generateUpdate (float amount, Queue<StateUpdate> stateQueue);
}

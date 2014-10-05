package commandParsing;

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

    private Queue<StateUpdate> updateQueue;
    private String[] commandString;

    /**
     * Method creates a CommandParser object from a command string
     *
     * @param commandName
     * @return
     */
    public static CommandParser createParser (String commandName) {
        try {
            return (CommandParser) Class.forName(commandName).newInstance();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {

            e.printStackTrace();
        }

        return new NullCommandParser();
    }

    /**
     * Method checks whether a string command is parsable
     *
     * @param string
     * @return
     */
    protected boolean isStringParsableAsFloat (String string) {
        boolean isParseable = true;

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i)) & string.charAt(i) != '.') {
                isParseable = false;
            }
        }

        return isParseable;
    }

    /**
     * Method checks whether a string is a valid command
     *
     * @param string
     * @return
     */
    protected boolean isCommandString (String string) {
        boolean isCommand = false;

        try {
            Class.forName(string).newInstance();
            isCommand = true;
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            isCommand = false;
        }

        return isCommand;
    }

    /**
     * Method checks whether the CommandParser object created is the correct one
     *
     * @param command
     * @return
     */
    protected abstract boolean isAppropriateCommand (CommandParser command);

    /**
     * Method checks whether the StateUpdate queue contains errors
     *
     * @param queue
     * @return
     */
    protected boolean errorOccured (Queue<StateUpdate> queue) {
        return queue.contains(new ParseError());
    }
}

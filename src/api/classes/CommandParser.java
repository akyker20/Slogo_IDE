package api.classes;

import java.util.Queue;


/**
 * Class parses String commands into CommandParser objects
 *
 * @author steven, stanley
 *
 */
public abstract class CommandParser {

    /**
     * Method creates a CommandParser object from a command string
     *
     * @param commandName
     * @return
     */
    public static CommandParser createParser (String commandName) {
        return null;

    }

    /**
     * Method checks whether a string command is parsable
     *
     * @param string
     * @return
     */
    protected boolean isStringParsableAsFloat (String string) {
        return false;

    }

    /**
     * Method checks whether a string is a valid command
     *
     * @param string
     * @return
     */
    protected boolean isCommandString (String string) {
        return false;

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
        return false;
    }
}

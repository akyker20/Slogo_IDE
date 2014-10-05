package api.classes;

import java.util.Iterator;
import java.util.Queue;


/**
 * Class parses String turtle commands into TurtleCommand objects
 *
 * @author steve, stanley
 *
 */
public abstract class TurtleCommand extends CommandParser {

    /**
     * Method parses Turtle command strings and adds StateUpdate objects to the StateUpdate queue
     *
     * @param commandString
     * @param updateQueue
     */
    public void parse (Iterator<String> commandString, Queue<StateUpdate> updateQueue) {

    }

    @Override
    protected boolean isAppropriateCommand (CommandParser command) {
        return false;
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

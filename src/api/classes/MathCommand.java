package api.classes;

import java.util.Iterator;
import java.util.Queue;


/**
 * Class parses String math commands into MathCommand objects
 *
 * @author steve, stanley
 *
 */
public abstract class MathCommand extends CommandParser {

    /**
     * Method gets the two operands to be acted on by the math operation
     *
     * @param commandString
     * @param updateQueue
     */
    protected void generateComponents (Iterator<String> commandString,
                                       Queue<StateUpdate> updateQueue) {

    }

    /**
     * This method is used to deal with nested math operations by making more calls to the
     * generateComponents method
     *
     * @param commandString
     * @param updateQueue
     * @return
     */
    public abstract float parse (Iterator<String> commandString, Queue<StateUpdate> updateQueue);

    @Override
    protected boolean isAppropriateCommand (CommandParser command) {
        return false;

    }

}

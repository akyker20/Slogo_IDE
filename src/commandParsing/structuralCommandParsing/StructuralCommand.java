package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;


/**
 * Class parses String structural commands into StructuralCommand objects
 *
 * @author steve, stanley
 *
 */
public abstract class StructuralCommand extends CommandParser {
    /**
     * Method parses Structural command strings into StructuralCommand objects
     *
     * @param commandString
     * @param updateQueue
     */
    public abstract void parse (Iterator<String> commandString, Queue<StateUpdate> updateQueue);

    @Override
    protected boolean isAppropriateCommand (CommandParser command) {
        // TODO Auto-generated method stub
        return false;
    }

}

package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;


public abstract class StructuralCommand extends CommandParser {

    public abstract void parse (Iterator<String> commandString, Queue<StateUpdate> updateQueue);

    @Override
    protected boolean isAppropriateCommand (CommandParser command) {
        // TODO Auto-generated method stub
        return false;
    }

}

package commandParsing.mathCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import stateUpdate.ParseError;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;


public abstract class MathCommand extends CommandParser {

    List<Float> components = new ArrayList<Float>();

    protected void generateComponents (Iterator<String> commandString,
                                       Queue<StateUpdate> updateQueue) {
        while (components.size() < 2) {
            String stringOfInterest = commandString.next();

            if (isCommandString(stringOfInterest)) {
                if (isAppropriateCommand(createParser(stringOfInterest))) {
                    MathCommand command = (MathCommand) createParser(stringOfInterest);
                    components.add(command.parse(commandString, updateQueue));
                    if (errorOccured(updateQueue)) { return; }
                }
                else {
                    updateQueue.clear();
                    updateQueue.add(new ParseError());
                    return;
                }
            }
            else {
                if (isStringParsableAsFloat(stringOfInterest)) {
                    components.add(Float.parseFloat(stringOfInterest));

                }
            }
        }
    }

    public abstract float parse (Iterator<String> commandString, Queue<StateUpdate> updateQueue);

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

}

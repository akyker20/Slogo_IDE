package commandParsing.userCommandParsing;

import java.util.Iterator;
import java.util.Queue;
import workspaceState.UserDefinedCommandCollection.Command;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.NullCommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class UserInstruction extends CommandParser {

    public UserInstruction (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    String commandName;
    private Command command;

    @Override
    public double parse (Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
            throws SLOGOException {
        commandName = commandStringIterator.next();
        command = workspace.commands.fetchUserDefinedCommand(commandName);
        accumulateComponents(commandStringIterator, command.getNumArguments(), objectQueue);
        for (int i = 0; i < command.getParameters().size(); i++) {
            workspace.variables.storeVariable(command.getParameters().get(i),
                                              expressionComponents.get(i));
        }
        Iterator<String> thisCommandIterator = command.getCommandIterator();
        double returnValue = 0;
        while (thisCommandIterator.hasNext()) {
            CommandParser parser = new NullCommandParser(workspace);
            parser = CommandParser.createParser(thisCommandIterator.next(), workspace);
            returnValue = parser.parse(thisCommandIterator, objectQueue);
        }
        return returnValue;
    }

    @Override
    protected void accumulateComponents (Iterator<String> commandStringIterator,
                                         int numberToAccumulate,
                                         Queue<DrawableObject> objectQueue) throws SLOGOException {
        expressionComponents.clear();
        while (expressionComponents.size() < numberToAccumulate) {
            if (!commandStringIterator.hasNext()) {
                double defaultValueOfParameter =
                        workspace.variables.fetchVariable(command.getParameters()
                                                          .get(expressionComponents.size()));
                expressionComponents.add(defaultValueOfParameter);
            }
            else {
                String stringOfInterest = commandStringIterator.next();

                if (isStringParsableAsCommand(stringOfInterest)) {
                    CommandParser commandParser = createParser(stringOfInterest, workspace);
                    expressionComponents.add(commandParser
                                             .parse(commandStringIterator, objectQueue));
                }
                else {
                    objectQueue.clear();
                    throw new CompileTimeParsingException(stringOfInterest);
                }
            }
        }
    }

}

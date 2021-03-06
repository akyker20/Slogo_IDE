package commandParsing.userCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.UserDefinedCommandGenerator;
import commandParsing.drawableObectGenerationInterfaces.UserDefinedVariableGenerator;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.SLOGOException;
import commandParsing.structuralCommandParsing.StructuralCommand;
import drawableobject.DrawableObject;

/**
 * This class is the MakeUserInstruction class that contains the information for actually creating and defining new user instructions.
 * 
 * @author Stanley Yuan, Steve Kuznetsov
 *
 */

public class MakeUserInstruction extends StructuralCommand implements UserDefinedCommandGenerator,
UserDefinedVariableGenerator {

    public MakeUserInstruction (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    private List<String> parameters = new ArrayList<String>();

    @Override
    public double parse (Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
            throws SLOGOException {
        CommandParser commandParser = createParser(commandStringIterator.next(), workspace);
        if (!(commandParser instanceof UserInstruction)) { throw new CompileTimeParsingException(
                                                                                                 "expected command name"); }
        String potentialCommandName = commandStringIterator.next();
        if (!isStringParsableAsCommand(potentialCommandName)) { return 0; }

        extractCommandsBetweenBraces(commandStringIterator);

        Iterator<String> variableIterator = enclosedCommands.iterator();

        while (variableIterator.hasNext()) {
            parameters.add(getVariable(variableIterator, objectQueue));
        }
        for (String varName : parameters) {
            if (!workspace.variables.variableExists(varName)) {
                workspace.variables.storeVariable(varName, 0);
                objectQueue.add(generateDrawableObjectRepresentingVariable(workspace.variables
                                                                           .fetchWorkspaceVariable(varName)));
            }
        }
        int numArgs = parameters.size();
        extractCommandsBetweenBraces(commandStringIterator);
        try {
            Queue<DrawableObject> tempQueue = new LinkedList<DrawableObject>();
            parseCommandsBetweenBraces(enclosedCommands.iterator(), tempQueue);
        }
        catch (SLOGOException e) {
            return 0;
        }
        workspace.commands.storeUserDefinedCommand(potentialCommandName, numArgs, enclosedCommands,
                                                   parameters);
        objectQueue
        .add(generateDrawableObjectRepresentingCommand(
                                                       workspace.commands
                                                       .fetchUserDefinedCommand(potentialCommandName),
                                                       workspace.translator));
        return 1;
    }
}

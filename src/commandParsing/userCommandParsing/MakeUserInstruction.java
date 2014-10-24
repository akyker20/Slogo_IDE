package commandParsing.userCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.drawableObectGenerationInterfaces.UserDefinedCommandGenerator;
import commandParsing.exceptions.SLOGOException;
import commandParsing.structuralCommandParsing.StructuralCommand;
import drawableobject.DrawableObject;

public class MakeUserInstruction extends StructuralCommand implements UserDefinedCommandGenerator {

	public MakeUserInstruction(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	private List<String> parameters = new ArrayList<String>();

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		String potentialCommandName = commandString.next();
		if (!isStringParsableAsCommand(potentialCommandName)) {
			return 0;
		}

		extractCommandsBetweenBraces(commandString);

		Iterator<String> variableIterator = enclosedCommands.iterator();

		while (variableIterator.hasNext()) {
			parameters.add(getVariable(variableIterator, objectQueue));
		}
		for (String varName : parameters) {
			if (!workspace.variables.variableExists(varName)) {
				workspace.variables.storeVariable(varName, 0);
				// Is this necessary?
			}
		}
		int numArgs = parameters.size();
		extractCommandsBetweenBraces(commandString);
		try {
			Queue<DrawableObject> tempQueue = new LinkedList<DrawableObject>();
			parseCommandsBetweenBraces(enclosedCommands.iterator(), tempQueue);
		} catch (SLOGOException e) {
			return 0;
		}
		workspace.commands.storeUserDefinedCommand(potentialCommandName, numArgs, enclosedCommands,
				parameters);
		return 1;
	}
}
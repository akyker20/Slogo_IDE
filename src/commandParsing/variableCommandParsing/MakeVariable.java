package commandParsing.variableCommandParsing;

import gui.variableslist.WorkspaceVariable;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.VariableGenerator;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.SLOGOException;
import commandParsing.structuralCommandParsing.StructuralCommand;
import drawableobject.DrawableObject;

public class MakeVariable extends StructuralCommand implements VariableGenerator {

	public MakeVariable(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		CommandParser commandParser = (CommandParser) createParser(commandStringIterator.next(), workspace);
		if (!(commandParser instanceof Variable)) {
			throw new CompileTimeParsingException("expected variable name");
		}
		String variableName = commandStringIterator.next();
		if (!workspace.translator.matchesVariablePattern(variableName)) {
			throw new CompileTimeParsingException("expected variable name: " + variableName);
		}
		accumulateComponents(commandStringIterator, 1, objectQueue);
		double amountToAssign = expressionComponents.get(0);
		WorkspaceVariable variable = workspace.variables.storeVariable(variableName, amountToAssign);
		objectQueue.add(generateDrawableObjectRepresentingVariable(variable));
		return amountToAssign;
	}

}

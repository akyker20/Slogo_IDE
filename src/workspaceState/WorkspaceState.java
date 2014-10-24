package workspaceState;

import gui.variableslist.WorkspaceVariable;

import java.util.Map;

import translator.Translator;

public class WorkspaceState {

	public Translator translator;
	public UserDefinedVariableCollection variables = new UserDefinedVariableCollection();
	public UserDefinedCommandCollection commands = new UserDefinedCommandCollection();
	public TurtleCollection turtles = new TurtleCollection();


	public WorkspaceState (Turtle someTurtle, Map<String,WorkspaceVariable> variables, Translator someTranslator) {
		turtles.addTurtle(someTurtle);
		translator = someTranslator;
	}
}

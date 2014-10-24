package workspace;

import gui.variableslist.WorkspaceVariable;

import java.util.Map;

import translator.Translator;

public class Workspace {

	public Translator translator;
	public UserDefinedVariableCollection variables = new UserDefinedVariableCollection();
	public UserDefinedCommandCollection commands = new UserDefinedCommandCollection();
	public TurtleCollection turtles = new TurtleCollection();


	public Workspace (Turtle someTurtle, Map<String,WorkspaceVariable> variables, Translator someTranslator) {
		turtles.addTurtle(someTurtle);
		translator = someTranslator;
	}
}

package state;

import gui.variableslist.WorkspaceVariable;

import java.util.Map;

import translator.Translator;

public class State {

	public Translator translator;
	public UserDefinedVariableCollection variables = new UserDefinedVariableCollection();
	public UserDefinedCommandCollection commands = new UserDefinedCommandCollection();
	public Turtles turtles = new Turtles();


	public State (Turtle someTurtle, Map<String,WorkspaceVariable> variables, Translator someTranslator) {
		turtles.addTurtle(someTurtle);
		translator = someTranslator;
	}
}

package workspaceState;

import translator.Translator;

public class WorkspaceState {

	public Translator translator;
	public UserDefinedVariableCollection variables = new UserDefinedVariableCollection();
	public UserDefinedCommandCollection commands = new UserDefinedCommandCollection();
	public TurtleCollection turtles = new TurtleCollection();
	public ColorPalette colorPalette = new ColorPalette();

}

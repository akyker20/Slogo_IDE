package workspaceState;


import javafx.scene.paint.Color;

import commandParsing.exceptions.LanguageFileNotFoundException;
import commandParsing.exceptions.PropertyFileAccessException;

import translator.Translator;

public class WorkspaceState {

	public Translator translator;
	public UserDefinedVariableCollection variables;
	public UserDefinedCommandCollection commands;
	public TurtleCollection turtles;
	public Palette<Color> colorPalette = new Palette<Color>();
	public Palette<Shape> shapePalette = new Palette<Shape>();
	
	public WorkspaceState() throws LanguageFileNotFoundException, PropertyFileAccessException{
		translator = new Translator("english");
		variables = new UserDefinedVariableCollection();
		commands = new UserDefinedCommandCollection();
		turtles = new TurtleCollection();
	}

}

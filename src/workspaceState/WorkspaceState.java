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
	public Palette<Color> colorPalette;
	public Palette<Shape> shapePalette;

	public WorkspaceState() throws LanguageFileNotFoundException, PropertyFileAccessException {
		translator = new Translator("english");
		variables = new UserDefinedVariableCollection();
		commands = new UserDefinedCommandCollection();
		turtles = new TurtleCollection();
		colorPalette = new Palette<Color>();
		addDefaultColorsToPalette();
		shapePalette = new Palette<Shape>();
		addDefaultShapesToPalette();
	}

	private void addDefaultShapesToPalette() {
		shapePalette
				.addToPalette(0, new Shape("/src/resources/guiResources/turtleImages/default_turtle.png"));
	}

	private void addDefaultColorsToPalette() {
		Color[] defaultColors = { Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
				Color.BLUE, Color.INDIGO, Color.VIOLET };
		for (int i = 0; i < defaultColors.length; i++) {
			colorPalette.addToPalette(i, defaultColors[i]);
		}
	}

}

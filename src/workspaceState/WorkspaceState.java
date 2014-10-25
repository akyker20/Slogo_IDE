package workspaceState;

import javafx.scene.paint.Color;
import translator.Translator;

public class WorkspaceState {

	public Translator translator;
	public UserDefinedVariableCollection variables = new UserDefinedVariableCollection();
	public UserDefinedCommandCollection commands = new UserDefinedCommandCollection();
	public TurtleCollection turtles = new TurtleCollection();
	public Palette<Color> colorPalette = new ColorPalette();
	public Palette<Shape> shapePalette = new ShapePalette();

}

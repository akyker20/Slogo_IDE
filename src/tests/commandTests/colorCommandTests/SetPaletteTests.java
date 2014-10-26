package tests.commandTests.colorCommandTests;

import static org.junit.Assert.assertTrue;
import javafx.scene.paint.Color;
import gui.factories.turtlefactory.TurtleFactory;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;
import tests.commandTests.CommandTester;
import workspaceState.Shape;

public class SetPaletteTests extends CommandTester {
	
	@Test
	public void SetPaletteTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setpalette 1");
		workspace.colorPalette.addToPalette(1, Color.DARKGREY);
		TurtleShapEdsf.
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		DrawableObject turtle = objectQueue.poll();
		assertTrue(turtle.getParameters().get(TurtleFactory.IMAGE_PATH)
				.equals(workspace.shapePalette.getFromPalette(1).getPath()));
	}
	
	@Test
	public void SetPaletteAfterSetPaletteTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setpalette 1 setpalette 0");
		workspace.shapePalette.addToPalette(1, new Shape("somePath/image.png"));

		double f = 0;

		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		System.out.println(objectQueue.size());
		DrawableObject turtle = objectQueue.poll();
		assertTrue(turtle.getParameters().get(TurtleFactory.IMAGE_PATH)
				.equals(workspace.shapePalette.getFromPalette(1).getPath()));
		turtle = objectQueue.poll();
		assertTrue(turtle.getParameters().get(TurtleFactory.IMAGE_PATH)
				.equals(workspace.shapePalette.getFromPalette(0).getPath()));
	}

}

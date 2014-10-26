package tests.commandTests.colorCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.turtlefactory.TurtleFactory;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;
import tests.commandTests.CommandTester;
import workspaceState.Shape;

public class GetShapeTests extends CommandTester {

	@Test
	public void GetShapeTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("shape");

		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 0);
		assertTrue(workspace.shapePalette.getFromPalette(0).getPath()
				.equals(workspace.turtles.getLastActiveTurtle().getShape().getPath()));
	}

	@Test
	public void GetShapeAfterSetShapeTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setshape 1 shape");
		workspace.shapePalette.addToPalette(1, new Shape("somePath/image.png"));

		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 1);
		assertTrue(workspace.shapePalette.getFromPalette(1).getPath()
				.equals("somePath/image.png"));
	}

}
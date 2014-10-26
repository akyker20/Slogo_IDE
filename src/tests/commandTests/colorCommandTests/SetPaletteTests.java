package tests.commandTests.colorCommandTests;

import static org.junit.Assert.assertTrue;
import javafx.scene.paint.Color;
import gui.factories.ColorPaletteEntryFactory;
import gui.factories.PaneFactory;
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
		setUpCommands("setpalette 10 0 0 0");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		DrawableObject colorIndex = objectQueue.poll();
		assertTrue(colorIndex.getParameters().get(ColorPaletteEntryFactory.COLOR)
				.equals(workspace.colorPalette.getFromPalette(10).toString()));
		assertTrue(colorIndex.getParameters().get(ColorPaletteEntryFactory.INDEX).equals("10"));
		assertTrue(f==10);
	}
	
	@Test
	public void SetPaletteAfterSetPaletteTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setpalette 10 2 3 4 setpalette 10 0 0 0");
		workspace.shapePalette.addToPalette(1, new Shape("somePath/image.png"));

		double f = 0;

		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		objectQueue.poll();
		DrawableObject colorIndex = objectQueue.poll();
		assertTrue(colorIndex.getParameters().get(ColorPaletteEntryFactory.COLOR)
				.equals(workspace.colorPalette.getFromPalette(10).toString()));
		assertTrue(colorIndex.getParameters().get(ColorPaletteEntryFactory.INDEX).equals("10"));
		assertTrue(f==10);
	}

}

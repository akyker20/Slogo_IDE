package tests.commandTests.colorCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.ShapePaletteEntryFactory;

import org.junit.Test;

import tests.commandTests.CommandTester;
import workspaceState.Shape;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;

public class SetShapePaletteTests extends CommandTester {
	
	@Test
	public void SetShapePaletteTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setshapepalette 10 /blah/blah.png");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		DrawableObject shapePaletteUpdate = objectQueue.poll();
		assertTrue(shapePaletteUpdate.getParameters().get(ShapePaletteEntryFactory.IMAGE_PATH)
				.equals(workspace.shapePalette.getFromPalette(10).getPath()));
		assertTrue(shapePaletteUpdate.getParameters().get(ShapePaletteEntryFactory.INDEX).equals("10"));
		assertTrue(f==10);
	}
	
	@Test
	public void SetShapePaletteAfterSetShapePaletteTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setshapepalette 10 somePath/image.png setssp 10 /blah/blah.png");

		double f = 0;

		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		objectQueue.poll();
		DrawableObject shapePaletteUpdate = objectQueue.poll();
		assertTrue(shapePaletteUpdate.getParameters().get(ShapePaletteEntryFactory.IMAGE_PATH)
				.equals(workspace.shapePalette.getFromPalette(10).getPath()));
		assertTrue(shapePaletteUpdate.getParameters().get(ShapePaletteEntryFactory.INDEX).equals("10"));
		assertTrue(f==10);
	}

}

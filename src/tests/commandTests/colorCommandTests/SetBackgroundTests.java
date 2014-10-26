package tests.commandTests.colorCommandTests;

import static org.junit.Assert.assertTrue;
import gui.componentdrawers.ComponentBuilder;
import gui.factories.FactoryBuilder;

import org.junit.Test;

import com.sun.prism.paint.Color;

import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class SetBackgroundTests extends CommandTester {
	
	@Test
	public void SetBackgroundTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setbg 0");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 0);	
		DrawableObject pane = objectQueue.poll();
		
		assertTrue(pane.getParent().equals(ComponentBuilder.SCREEN_DRAWER));
		assertTrue(pane.getType().equals(FactoryBuilder.CLEAR_GRID_FACTORY));
		assertTrue(pane.getParameters().get(PaneFactory.RESET_FLAG).equals("false"));
		assertTrue(pane.getParameters().get(PaneFactory.BACKGROUND_COLOR).equals(Color.BLACK.toString()));
		
			
		assertTrue(objectQueue.size()==0);
	}

}

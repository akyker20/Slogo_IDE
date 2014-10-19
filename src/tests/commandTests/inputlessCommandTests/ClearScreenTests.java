package tests.commandTests.inputlessCommandTests;

import static org.junit.Assert.assertTrue;
import gui.componentdrawers.ComponentInitializer;
import gui.factories.FactoryInitializer;
import gui.factories.TurtleFactory;

import org.junit.Test;

import tests.commandTests.CommandTester;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;

public class ClearScreenTests extends CommandTester {
	@Test
	public void ClearScreeenTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("cs");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 0);	
		DrawableObject pane = objectQueue.poll();
		DrawableObject turtle = objectQueue.poll();
		
		assertTrue(pane.getParent().equals(ComponentInitializer.GRID_DRAWER));
		assertTrue(pane.getType().equals(FactoryInitializer.CLEAR_GRID_FACTORY));
		assertTrue(pane.getParameters().size()==0);
		
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("100.0"));		
		assertTrue(objectQueue.size()==0);
		assertTrue(state.isTurtleShowing());
	}
}

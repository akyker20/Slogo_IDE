package tests.commandTests.inputlessCommandTests;

import static org.junit.Assert.assertTrue;
import javafx.scene.paint.Color;
import gui.componentdrawers.ComponentBuilder;
import gui.factories.FactoryBuilder;
import gui.factories.PaneFactory;
import gui.factories.turtlefactory.TurtleFactory;

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
		
		assertTrue(pane.getParent().equals(ComponentBuilder.SCREEN_DRAWER));
		assertTrue(pane.getType().equals(FactoryBuilder.CLEAR_GRID_FACTORY));
		assertTrue(pane.getParameters().get(PaneFactory.RESET_FLAG).equals("true"));
		assertTrue(pane.getParameters().get(PaneFactory.BACKGROUND_COLOR).equals(Color.WHITE.toString()));
		
		
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("100.0"));		
		assertTrue(objectQueue.size()==0);
		assertTrue(workspace.turtles.getLastActiveTurtle().isTurtleShowing());
	}
}

package tests.commandTests.inputlessCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.turtlefactory.TurtleFactory;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;
import tests.commandTests.CommandTester;

public class StampTests extends CommandTester {

	@Test
	public void StampTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("stamp");

		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 1);
		DrawableObject turtle = objectQueue.poll();

		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.TURTLE_ID).equals(Integer.toString(941083987)));
		assertTrue(turtle.getParameters().get(TurtleFactory.DELETION_FLAG).equals("false"));
		
		assertTrue(objectQueue.size() == 0);

	}

}

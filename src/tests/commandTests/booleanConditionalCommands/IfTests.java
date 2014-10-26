package tests.commandTests.booleanConditionalCommands;

import static org.junit.Assert.assertTrue;
import gui.factories.LineFactory;
import gui.factories.turtlefactory.TurtleFactory;
import org.junit.Test;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;
import tests.commandTests.CommandTester;

public class IfTests extends CommandTester {
	@Test
	public void TrueTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("if less? 1 10 [ fd 50 ]");

		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 50);

		DrawableObject line = objectQueue.poll();
		DrawableObject turtle = objectQueue.poll();

		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 50.0"));

		assertTrue(line.getParent().equals(LineFactory.PARENT));
		assertTrue(line.getType().equals(LineFactory.TYPE));
		assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 0.0"));
		assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("0.0 50.0"));

		assertTrue(objectQueue.size()==0);
	}
	
	@Test
	public void FalseTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("if less? 10 1 [ fd 50 ]");

		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 0);
		assertTrue(objectQueue.size()==0);
	}
}

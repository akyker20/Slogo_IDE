package tests.commandTests.singleInputFloatTests;

import static org.junit.Assert.assertTrue;
import gui.factories.LineFactory;
import gui.factories.TurtleFactory;

import org.junit.Test;

import tests.commandTests.CommandTester;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;


public class BackwardTests extends CommandTester{

	@Test
	public void IntegerParsingTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("bk 50");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 50);
		DrawableObject line = objectQueue.poll();
		DrawableObject turtle = objectQueue.poll();
		
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 -50.0"));

		assertTrue(line.getParent().equals(LineFactory.PARENT));
		assertTrue(line.getType().equals(LineFactory.TYPE));
		assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 0.0"));
		assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("0.0 -50.0"));
		
		assertTrue(objectQueue.size()==0);
	}
}

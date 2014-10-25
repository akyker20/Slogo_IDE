package tests.commandTests.singleInputFloatTests;

import static org.junit.Assert.assertTrue;
import gui.factories.turtlefactory.TurtleFactory;
import org.junit.Test;
import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class RightTests extends CommandTester{
	
	@Test
	public void IntegerParsingTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("rt 50");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 50);
		DrawableObject turtle = objectQueue.poll();
		
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("50.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 0.0"));
		
		assertTrue(objectQueue.size()==0);

	}

}

package tests.commandTests.recurringCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.LineFactory;
import gui.factories.TurtleFactory;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;
import tests.commandTests.CommandTester;

public class DoTimesTests extends CommandTester {
	@Test
	public void DoTimesTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("dotimes [ :somevar 10 ] [ fd 50 ]");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 50);
		
		for(int i=1;i<11;i++){
			DrawableObject line = objectQueue.poll();
			DrawableObject turtle = objectQueue.poll();
			
			assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
			assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
			assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
			assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 " + String.valueOf(50.0*i)));
			
			assertTrue(line.getParent().equals(LineFactory.PARENT));
			assertTrue(line.getType().equals(LineFactory.TYPE));
			assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 " + String.valueOf(50.0*(i-1))));
			assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("0.0 " + String.valueOf(50.0*i)));
		}
		assertTrue(objectQueue.size()==0);
	}
}

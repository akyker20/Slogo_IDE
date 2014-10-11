package tests.commandTests.turtleQueryTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import tests.commandTests.CommandTester;

public class YCoordinateTests extends CommandTester {
	@Test
	public void IntegerParsingTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("ycor");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 0);		
		assertTrue(objectQueue.size()==0);
	}
	
	@Test
	public void YCorAfterMoveTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("fd 50 ycor");
		
		double f = 0;
		
		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 50);		
	}
}

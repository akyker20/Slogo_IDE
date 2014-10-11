package tests.commandTests.turtleQueryTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tests.commandTests.CommandTester;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

public class HeadingTests extends CommandTester {
	@Test
	public void HeadingTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("heading");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 0);		
		assertTrue(objectQueue.size()==0);
	}

	@Test
	public void HeadingAfterMoveTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("rt 50 heading");
		
		double f = 0;
		
		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 50);		
	}
}

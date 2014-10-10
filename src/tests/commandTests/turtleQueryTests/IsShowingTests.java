package tests.commandTests.turtleQueryTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import tests.commandTests.CommandTester;

public class IsShowingTests extends CommandTester {
	@Test
	public void ShowingTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("showing?");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 1);		
		assertTrue(objectQueue.size()==0);
	}
	
	@Test
	public void ShowingAfterHideTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("ht showing?");
		
		double f = 0;
		
		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 0);		
	}
}

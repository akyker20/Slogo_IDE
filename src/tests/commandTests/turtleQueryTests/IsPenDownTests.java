package tests.commandTests.turtleQueryTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import tests.commandTests.CommandTester;

public class IsPenDownTests extends CommandTester {
	@Test
	public void IsPenDownTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("pendown?");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 1);		
		assertTrue(objectQueue.size()==0);
	}
	
	@Test
	public void PenDownAfterPenUp() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("pu pendown?");
		
		double f = 0;
		
		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 0);		
	}
}

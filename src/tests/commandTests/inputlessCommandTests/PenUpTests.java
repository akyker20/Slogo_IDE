package tests.commandTests.inputlessCommandTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import tests.commandTests.CommandTester;

public class PenUpTests extends CommandTester {
	@Test
	public void PenUpTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("pu");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 0);		
		assertTrue(objectQueue.size()==0);
		assertFalse(state.isPenDown());
	}

	@Test
	public void HeadingAfterMoveTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("pd pu");
		
		double f = 0;
		
		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 0);	
		assertTrue(objectQueue.size()==0);
		assertFalse(state.isPenDown());
	}
}

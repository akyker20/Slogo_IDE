package tests.commandTests.singleInputFloatTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tests.commandTests.CommandTester;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;


public class BackwardTests extends CommandTester{

	@Test
	public void IntegerParsingTest() throws SLOGOException {
		clearQueue();
		setUpCommands("bk 50");
		
		CommandParser parser = createCommand();
		float f = parser.parse(commands, objectQueue);
		assertTrue(f == 50);
		assertTrue(state.getXLocation() == -50);
		assertTrue(state.getYLocation() == 0);
	}
}

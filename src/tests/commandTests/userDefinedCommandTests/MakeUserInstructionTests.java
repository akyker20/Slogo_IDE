package tests.commandTests.userDefinedCommandTests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import tests.commandTests.CommandTester;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

public class MakeUserInstructionTests extends CommandTester {
	@Test
	public void MakeCommandTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("to command [ :var :varb :varc ] [ fd 20 ]");

		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 1);		
		assertTrue(objectQueue.size()==0);
		assertTrue(state.fetchVariable(":var") == 0);
		assertTrue(state.fetchVariable(":varb") == 0);
		assertTrue(state.fetchVariable(":varc") == 0);
		List<String> translatedCommand = state.translateToList("fd 20");
		assertTrue(state.fetchUserDefinedCommand("command").equals(translatedCommand));
	}

	@Test
	public void MakeCommandTestWithPreviousVariables() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("set :var 20 to command [ :var :varb :varc ] [ fd 20 ]");
		
		double f = 0;
		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 1);		
		assertTrue(objectQueue.size()==0);
		assertTrue(state.fetchVariable(":var") == 20);
		assertTrue(state.fetchVariable(":varb") == 0);
		assertTrue(state.fetchVariable(":varc") == 0);
		List<String> translatedCommand = state.translateToList("fd 20");
		assertTrue(state.fetchUserDefinedCommand("command").equals(translatedCommand));
	}
}

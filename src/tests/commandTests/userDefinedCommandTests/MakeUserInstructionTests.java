package tests.commandTests.userDefinedCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.WorkspaceVariableFactory;
import java.util.List;
import org.junit.Test;
import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class MakeUserInstructionTests extends CommandTester {
	@Test
	public void MakeCommandTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("to command [ :var :varb :varc ] [ fd 20 ]");

		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 1);		

		assertTrue(objectQueue.size()==0);
		assertTrue(state.variables.fetchVariable(":var") == 0);
		assertTrue(state.variables.fetchVariable(":varb") == 0);
		assertTrue(state.variables.fetchVariable(":varc") == 0);
		List<String> translatedCommand = state.translator.translateToList("fd 20");
		assertTrue(state.commands.fetchUserDefinedCommand("command").equals(translatedCommand));
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
		DrawableObject refreshVariables = objectQueue.poll();
		
		assertTrue(refreshVariables.getParent().equals(WorkspaceVariableFactory.PARENT));
		assertTrue(refreshVariables.getType().equals(WorkspaceVariableFactory.TYPE));
		assertTrue(refreshVariables.getParameters().size()==2);		
		assertTrue(state.variables.fetchVariable(":var") == 20);
		assertTrue(state.variables.fetchVariable(":varb") == 0);
		assertTrue(state.variables.fetchVariable(":varc") == 0);
		List<String> translatedCommand = state.translator.translateToList("fd 20");
		assertTrue(state.commands.fetchUserDefinedCommand("command").equals(translatedCommand));
	}
}


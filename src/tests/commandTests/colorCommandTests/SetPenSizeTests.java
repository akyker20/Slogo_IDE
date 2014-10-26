package tests.commandTests.colorCommandTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sun.prism.paint.Color;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import tests.commandTests.CommandTester;

public class SetPenSizeTests extends CommandTester {
	
	@Test
	public void SetPenSizeTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setps 1");

		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 1);
		assertTrue(objectQueue.size() == 0);
		assertTrue(workspace.turtles.getLastActiveTurtle().pen.getPenSize()==1);
	}

	@Test
	public void SetPenColorAfterSetPenColorTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setpc 4 setpc 0");

		double f = 0;
		while (commands.hasNext()) {
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 0);
		assertTrue(objectQueue.size() == 0);
		assertTrue(!workspace.turtles.getLastActiveTurtle().pen.getPenColor().equals(Color.BLACK));
	}

}

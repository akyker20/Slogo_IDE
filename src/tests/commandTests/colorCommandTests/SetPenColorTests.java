package tests.commandTests.colorCommandTests;

import static org.junit.Assert.assertTrue;
import javafx.scene.paint.Color;
import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import tests.commandTests.CommandTester;

public class SetPenColorTests extends CommandTester {

	@Test
	public void SetPenColorTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setpc 0");

		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 0);
		assertTrue(objectQueue.size() == 0);
		assertTrue(workspace.turtles.getLastActiveTurtle().pen.getPenColor().equals(Color.BLACK));
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
		assertTrue(workspace.turtles.getLastActiveTurtle().pen.getPenColor().equals(Color.BLACK));
	}

}

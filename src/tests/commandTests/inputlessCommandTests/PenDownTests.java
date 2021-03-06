package tests.commandTests.inputlessCommandTests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;


public class PenDownTests extends CommandTester {
    @Test
    public void PenUpTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("pd");

        CommandParser parser = createCommand();
        double f = parser.parse(commands, objectQueue);
        assertTrue(f == 1);
        assertTrue(objectQueue.size() == 0);
        assertTrue(workspace.turtles.getLastActiveTurtle().pen.isPenDown());
    }

    @Test
    public void HeadingAfterMoveTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("pu pd pu pd");

        double f = 0;

        while (commands.hasNext()) {
            CommandParser parser = createCommand();
            f = parser.parse(commands, objectQueue);
        }
        assertTrue(f == 1);
        assertTrue(objectQueue.size() == 0);
        assertTrue(workspace.turtles.getLastActiveTurtle().pen.isPenDown());
    }
}

package tests.commandTests.turtleQueryTests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;


public class XCoordinateTests extends CommandTester {
    @Test
    public void XCorTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("xcor");

        CommandParser parser = createCommand();
        double f = parser.parse(commands, objectQueue);
        assertTrue(f == 0);
        assertTrue(objectQueue.size() == 0);
    }

    @Test
    public void XCorAfterMoveTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("rt 90 fd 50 xcor");

        double f = 0;

        while (commands.hasNext()) {
            CommandParser parser = createCommand();
            f = parser.parse(commands, objectQueue);
        }
        assertTrue(f == 50);
    }
}

package tests.commandTests.turtleQueryTests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;


public class GetPenColorTests extends CommandTester {

    @Test
    public void GetPenColorTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("pc");

        CommandParser parser = createCommand();
        double f = parser.parse(commands, objectQueue);
        assertTrue(f == 0);
        assertTrue(workspace.colorPalette.getFromPalette(0)
                   .equals(workspace.turtles.getLastActiveTurtle().pen.getPenColor()));
    }

    @Test
    public void GetPenColorAfterSettingPenColorTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("setpc 1 pc");

        CommandParser parser = createCommand();
        double f = parser.parse(commands, objectQueue);
        assertTrue(f == 1);
        assertTrue(workspace.colorPalette.getFromPalette(1)
                   .equals(workspace.turtles.getLastActiveTurtle().pen.getPenColor()));
    }

}

package tests.commandTests.colorCommandTests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;


public class SetPenSizeTests extends CommandTester {

    @Test
    public void SetPenSizeTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("setps 1");

        CommandParser parser = createCommand();
        double f = parser.parse(commands, objectQueue);
        assertTrue(f == 1);
        assertTrue(objectQueue.size() == 0);
        assertTrue(workspace.turtles.getLastActiveTurtle().pen.getPenSize() == 1);
    }

    @Test
    public void SetPenSizeAfterSetPenSizeTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("setps 3 setps 1");

        double f = 0;

        while (commands.hasNext()) {
            CommandParser parser = createCommand();
            f = parser.parse(commands, objectQueue);
        }
        assertTrue(f == 1);
        assertTrue(objectQueue.size() == 0);
        assertTrue(workspace.turtles.getLastActiveTurtle().pen.getPenSize() == 1);
    }

}

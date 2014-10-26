package tests.commandTests.booleanCommandTests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;


public class EqualTests extends CommandTester {

    @Test
    public void IntegerParseTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("equal? 50 50");
        CommandParser parser = createCommand();
        double f = parser.parse(commands, objectQueue);
        assertTrue(f == 1);
    }

    @Test
    public void FloatParseTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("equal? 50.0 50.0");
        CommandParser parser = createCommand();

        double f = parser.parse(commands, objectQueue);

        assertTrue(f == 1);
    }

    @Test
    public void IntegerLongParseTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("equal? 50 equal? 50 50");
        CommandParser parser = createCommand();

        double f = parser.parse(commands, objectQueue);

        assertTrue(f == 0);
    }

    @Test
    public void IntegerLongerParseTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("equal? 50 equal? 1 equal? 0 equal? 50 equal? 50 and 50 - 50 50");
        CommandParser parser = createCommand();

        double f = parser.parse(commands, objectQueue);

        assertTrue(f == 0);
    }

    @Test
    public void SyntaxErrorParseTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("equal? 50 equal? 50 50..");
        CommandParser parser = createCommand();

        try {
            parser.parse(commands, objectQueue);
        }
        catch (SLOGOException e) {
            assertTrue(e.generateErrorMessage().getParameters().values()
                       .contains("Error parsing following string: " + "50.." + ". Incorrect syntax."));
        }
    }
}

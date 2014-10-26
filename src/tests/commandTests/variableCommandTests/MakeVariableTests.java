package tests.commandTests.variableCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.WorkspaceVariableFactory;
import org.junit.Test;
import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class MakeVariableTests extends CommandTester {
    @Test
    public void MakeTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("set :var 20");

        CommandParser parser = createCommand();
        double f = parser.parse(commands, objectQueue);
        assertTrue(f == 20);
        DrawableObject refreshVariables = objectQueue.poll();

        assertTrue(refreshVariables.getParent().equals(WorkspaceVariableFactory.PARENT));
        assertTrue(refreshVariables.getType().equals(WorkspaceVariableFactory.TYPE));
        assertTrue(refreshVariables.getParameters().size() == 2);
        assertTrue(objectQueue.size() == 0);
        assertTrue(workspace.variables.fetchVariable(":var") == 20);
    }

    @Test
    public void ComplexMakeTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("set :var sum 20 20");

        CommandParser parser = createCommand();
        double f = parser.parse(commands, objectQueue);
        assertTrue(f == 40);
        DrawableObject refreshVariables = objectQueue.poll();

        assertTrue(refreshVariables.getParent().equals(WorkspaceVariableFactory.PARENT));
        assertTrue(refreshVariables.getType().equals(WorkspaceVariableFactory.TYPE));
        assertTrue(refreshVariables.getParameters().size() == 2);
        assertTrue(objectQueue.size() == 0);
        assertTrue(workspace.variables.fetchVariable(":var") == 40);
    }

    @Test
    public void ManyMakeTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("set :var 20 set :varb 25 set :var 25 set :varc 40");

        double f = 0;

        while (commands.hasNext()) {
            CommandParser parser = createCommand();
            f = parser.parse(commands, objectQueue);
        }
        assertTrue(f == 40);
        for (int i = 0; i < 4; i++) {
            DrawableObject refreshVariables = objectQueue.poll();

            assertTrue(refreshVariables.getParent().equals(WorkspaceVariableFactory.PARENT));
            assertTrue(refreshVariables.getType().equals(WorkspaceVariableFactory.TYPE));
            assertTrue(refreshVariables.getParameters().size() == 2);
        }
        assertTrue(objectQueue.size() == 0);
        assertTrue(workspace.variables.fetchVariable(":var") == 25);
        assertTrue(workspace.variables.fetchVariable(":varb") == 25);
        assertTrue(workspace.variables.fetchVariable(":varc") == 40);
    }

}

package tests.commandTests.inputlessCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.turtlefactory.TurtleFactory;
import org.junit.Test;
import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class ShowTurtleTests extends CommandTester {
    @Test
    public void PenUpTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("st");

        CommandParser parser = createCommand();
        double f = parser.parse(commands, objectQueue);
        assertTrue(f == 1);
        DrawableObject turtle = objectQueue.poll();
        assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("100.0"));
        assertTrue(objectQueue.size() == 0);
        assertTrue(workspace.turtles.getLastActiveTurtle().isTurtleShowing());
    }

    @Test
    public void HeadingAfterMoveTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("ht st ht st");

        double f = 0;

        while (commands.hasNext()) {
            CommandParser parser = createCommand();
            f = parser.parse(commands, objectQueue);
        }
        assertTrue(f == 1);
        DrawableObject turtle = objectQueue.poll();
        assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("0.0"));
        turtle = objectQueue.poll();
        assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("100.0"));
        turtle = objectQueue.poll();
        assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("0.0"));
        turtle = objectQueue.poll();
        assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("100.0"));
        assertTrue(objectQueue.size() == 0);
        assertTrue(workspace.turtles.getLastActiveTurtle().isTurtleShowing());
    }
}

package tests.commandTests.inputlessCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.turtlefactory.TurtleFactory;
import org.junit.Test;
import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class MakeTurtleTest extends CommandTester {

    @Test
    public void MakeTurtleTester () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("mk");

        CommandParser parser = createCommand();
        double f = parser.parse(commands, objectQueue);
        assertTrue(f == 0);
        DrawableObject turtle = objectQueue.poll();

        assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
        assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
        assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
        assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 0.0"));
        assertTrue(turtle.getParameters().get(TurtleFactory.TURTLE_ID).equals(Integer.toString(2)));

        assertTrue(objectQueue.size() == 0);
    }

    @Test
    public void MakeTurtleIncrementsIDTester () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("mk");

        workspace.turtles.addTurtle(2);

        CommandParser parser = createCommand();
        double f = parser.parse(commands, objectQueue);
        assertTrue(f == 0);
        DrawableObject turtle = objectQueue.poll();

        assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
        assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
        assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
        assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 0.0"));
        assertTrue(turtle.getParameters().get(TurtleFactory.TURTLE_ID).equals(Integer.toString(3)));

        assertTrue(objectQueue.size() == 0);
    }

}

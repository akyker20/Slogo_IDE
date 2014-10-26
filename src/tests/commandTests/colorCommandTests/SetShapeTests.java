package tests.commandTests.colorCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.turtlefactory.TurtleFactory;
import org.junit.Test;
import tests.commandTests.CommandTester;
import workspaceState.Shape;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


public class SetShapeTests extends CommandTester {

    @Test
    public void SetShapeTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("setshape 1");
        workspace.shapePalette.addToPalette(1, new Shape("somePath/image.png"));

        CommandParser parser = createCommand();
        parser.parse(commands, objectQueue);
        DrawableObject turtle = objectQueue.poll();
        assertTrue(turtle.getParameters().get(TurtleFactory.IMAGE_PATH)
                   .equals(workspace.shapePalette.getFromPalette(1).getPath()));
    }

    @Test
    public void SetShapeAfterSetShapeTest () throws SLOGOException {
        resetTesterVariables();
        setUpCommands("setshape 1 setshape 0");
        workspace.shapePalette.addToPalette(1, new Shape("somePath/image.png"));

        while (commands.hasNext()) {
            CommandParser parser = createCommand();
            parser.parse(commands, objectQueue);
        }
        DrawableObject turtle = objectQueue.poll();
        assertTrue(turtle.getParameters().get(TurtleFactory.IMAGE_PATH)
                   .equals(workspace.shapePalette.getFromPalette(1).getPath()));
        turtle = objectQueue.poll();
        assertTrue(turtle.getParameters().get(TurtleFactory.IMAGE_PATH)
                   .equals(workspace.shapePalette.getFromPalette(0).getPath()));
    }

}

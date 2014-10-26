package tests.commandTests.inputlessCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.turtlefactory.TurtleFactory;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;
import tests.commandTests.CommandTester;

public class ClearStampsTest extends CommandTester {
	
	@Test
	public void StampTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("stamp clearstamps");
		
		double f = 0;

		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		objectQueue.poll();
		DrawableObject stampDeletion = objectQueue.poll();
		
		assertTrue(f == 1);
		
		assertTrue(stampDeletion.getParent().equals(TurtleFactory.PARENT));
		assertTrue(stampDeletion.getType().equals(TurtleFactory.TYPE));
		assertTrue(stampDeletion.getParameters().get(TurtleFactory.TURTLE_ID).equals(Integer.toString(941083987)));
		assertTrue(stampDeletion.getParameters().get(TurtleFactory.DELETION_FLAG).equals("true"));
		
		assertTrue(workspace.turtles.getStamps().size()==0);
		
		assertTrue(objectQueue.size() == 0);

	}

}

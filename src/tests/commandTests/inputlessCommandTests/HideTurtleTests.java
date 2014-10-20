package tests.commandTests.inputlessCommandTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import gui.factories.TurtleFactory;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;
import tests.commandTests.CommandTester;

public class HideTurtleTests extends CommandTester {
	@Test
	public void PenUpTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("ht");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 0);		
		DrawableObject turtle = objectQueue.poll();
		assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("0.0"));		
		assertTrue(objectQueue.size()==0);
		assertFalse(state.turtles.getLastActiveTurtle().isTurtleShowing());
	}

	@Test
	public void HeadingAfterMoveTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("st ht st ht");
		
		double f = 0;
		
		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 0);	
		DrawableObject turtle = objectQueue.poll();
		assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("100.0"));	
		turtle = objectQueue.poll();
		assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("0.0"));	
		turtle = objectQueue.poll();
		assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("100.0"));	
		turtle = objectQueue.poll();
		assertTrue(turtle.getParameters().get(TurtleFactory.OPACITY).equals("0.0"));	
		assertTrue(objectQueue.size()==0);
		assertFalse(state.turtles.getLastActiveTurtle().isTurtleShowing());
	}
}

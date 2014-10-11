package tests.commandTests.singleInputFloatTests;

import static org.junit.Assert.assertTrue;
import gui.factories.TurtleFactory;

import org.junit.Test;

import tests.commandTests.CommandTester;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;

public class SetHeading extends CommandTester {
	
	@Test
	public void SetHeadingNoInitialHeading() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("seth 50");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 50);
		DrawableObject turtle = objectQueue.poll();
		
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("50.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 0.0"));
		
		assertTrue(objectQueue.size()==0);

	}
	
	@Test
	public void SetHeadingWithPreviousHeading() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("rt 60 seth 50");
		
		
		double f = 0;
		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 10);
		objectQueue.poll();
		DrawableObject turtle = objectQueue.poll();
		
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("50.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 0.0"));
		
		assertTrue(objectQueue.size()==0);

	}

}

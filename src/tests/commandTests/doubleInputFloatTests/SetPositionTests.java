package tests.commandTests.doubleInputFloatTests;

import static org.junit.Assert.assertTrue;
import gui.factories.LineFactory;
import gui.factories.TurtleFactory;

import org.junit.Test;

import tests.commandTests.CommandTester;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;

public class SetPositionTests extends CommandTester {
	
	@Test
	public void BasicGOTOHomeTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setxy 0 0");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 0);
		DrawableObject line = objectQueue.poll();
		DrawableObject turtle = objectQueue.poll();
		
		assertTrue(line.getParent().equals(LineFactory.PARENT));
		assertTrue(line.getType().equals(LineFactory.TYPE));
		assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 0.0"));
		assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("0.0 0.0"));
		
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 0.0"));
		
		assertTrue(objectQueue.size()==0);
	}
	
	@Test
	public void BasicGOTOTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("setxy 20 15");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 25);
		DrawableObject line = objectQueue.poll();
		DrawableObject turtle = objectQueue.poll();
		
		assertTrue(line.getParent().equals(LineFactory.PARENT));
		assertTrue(line.getType().equals(LineFactory.TYPE));
		assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 0.0"));
		assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("20.0 15.0"));
		
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("20.0 15.0"));
		
		assertTrue(objectQueue.size()==0);
	}
	
	@Test
	public void GOTOAfterMovingAndRotatingPenDownTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("pd fd 50 rt 50 setxy 12 45");
		
		double f = 0;
		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 13);
		objectQueue.poll();
		objectQueue.poll();
		objectQueue.poll();
		DrawableObject line = objectQueue.poll();
		DrawableObject turtle = objectQueue.poll();
		
		assertTrue(line.getParent().equals(LineFactory.PARENT));
		assertTrue(line.getType().equals(LineFactory.TYPE));
		assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 50.0"));
		assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("12.0 45.0"));
		
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("50.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("12.0 45.0"));
		
		assertTrue(objectQueue.size()==0);
	}
	
	@Test
	public void GOTOAfterMovingAndRotatingPenUpTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("pu fd 50 rt 50 setxy 12 45");
		
		double f = 0;
		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 13);
		objectQueue.poll();
		objectQueue.poll();
		DrawableObject turtle = objectQueue.poll();
		
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("50.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("12.0 45.0"));
		
		assertTrue(objectQueue.size()==0);
	}

}

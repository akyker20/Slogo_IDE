package tests.commandTests.multipleTurtleCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.LineFactory;
import gui.factories.turtlefactory.TurtleFactory;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;
import tests.commandTests.CommandTester;

public class AskTests extends CommandTester {
	
	@Test
	public void SimpleAskTests() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("ask [ 1 2 ] [ fd 50 ]");

		double f = 0;

		while (commands.hasNext()) {
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 50);
		DrawableObject turtle = objectQueue.poll();
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.TURTLE_ID).equals(Integer.toString(2)));

		DrawableObject line = objectQueue.poll();
		assertTrue(line.getParent().equals(LineFactory.PARENT));
		assertTrue(line.getType().equals(LineFactory.TYPE));
		assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 0.0"));
		assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("0.0 50.0"));

		turtle = objectQueue.poll();
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 50.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.TURTLE_ID).equals(Integer.toString(1)));

		line = objectQueue.poll();
		assertTrue(line.getParent().equals(LineFactory.PARENT));
		assertTrue(line.getType().equals(LineFactory.TYPE));
		assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 0.0"));
		assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("0.0 50.0"));

		turtle = objectQueue.poll();
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 50.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.TURTLE_ID).equals(Integer.toString(2)));

		assertTrue(objectQueue.size() == 0);
		
		assertTrue(workspace.turtles.getActiveTurtles().contains(workspace.turtles.getTurtleWithID(1)));
		assertTrue(workspace.turtles.getActiveTurtles().size() == 1);
	}
	
	@Test
	public void ComplicatedAskTests() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("mk mk mk mk ask [ 1 2 ] [ fd 50 ]");

		double f = 0;

		while (commands.hasNext()) {
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 50);
		objectQueue.poll();
		objectQueue.poll();
		objectQueue.poll();
		objectQueue.poll();

		DrawableObject line = objectQueue.poll();
		assertTrue(line.getParent().equals(LineFactory.PARENT));
		assertTrue(line.getType().equals(LineFactory.TYPE));
		assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 0.0"));
		assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("0.0 50.0"));

		DrawableObject turtle = objectQueue.poll();
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 50.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.TURTLE_ID).equals(Integer.toString(1)));

		line = objectQueue.poll();
		assertTrue(line.getParent().equals(LineFactory.PARENT));
		assertTrue(line.getType().equals(LineFactory.TYPE));
		assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 0.0"));
		assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("0.0 50.0"));

		turtle = objectQueue.poll();
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 50.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.TURTLE_ID).equals(Integer.toString(2)));

		assertTrue(objectQueue.size() == 0);
		
		assertTrue(workspace.turtles.getActiveTurtles().contains(workspace.turtles.getTurtleWithID(1)));
		assertTrue(workspace.turtles.getActiveTurtles().contains(workspace.turtles.getTurtleWithID(2)));
		assertTrue(workspace.turtles.getActiveTurtles().contains(workspace.turtles.getTurtleWithID(3)));
		assertTrue(workspace.turtles.getActiveTurtles().contains(workspace.turtles.getTurtleWithID(4)));
		assertTrue(workspace.turtles.getActiveTurtles().contains(workspace.turtles.getTurtleWithID(5)));
		assertTrue(workspace.turtles.getActiveTurtles().size() == 5);
	}

}
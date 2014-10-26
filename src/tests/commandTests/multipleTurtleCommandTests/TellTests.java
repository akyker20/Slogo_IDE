package tests.commandTests.multipleTurtleCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.LineFactory;
import gui.factories.WorkspaceVariableFactory;
import gui.factories.turtlefactory.TurtleFactory;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;
import tests.commandTests.CommandTester;

public class TellTests extends CommandTester {
	
	@Test
	public void IntegerParsingTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("tell [ 1 2 ] fd 50");
		
		double f = 0;

		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 50);	
		DrawableObject line = objectQueue.poll();
		DrawableObject turtle = objectQueue.poll();
		
		for(int i=0;i<2;i++){
			DrawableObject refreshVariables = objectQueue.poll();
			
			assertTrue(refreshVariables.getParent().equals(WorkspaceVariableFactory.PARENT));
			assertTrue(refreshVariables.getType().equals(WorkspaceVariableFactory.TYPE));
			assertTrue(refreshVariables.getParameters().size()==2);
		}
		
		assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
		assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
		assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
		assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 50.0"));
		
		assertTrue(line.getParent().equals(LineFactory.PARENT));
		assertTrue(line.getType().equals(LineFactory.TYPE));
		assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 0.0"));
		assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("0.0 50.0"));
		
		assertTrue(objectQueue.size()==0);
	}

}

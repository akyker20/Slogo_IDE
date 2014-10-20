package tests.commandTests.recurringCommandTests;

import static org.junit.Assert.assertTrue;
import gui.factories.LineFactory;
import gui.factories.TurtleFactory;
import gui.factories.WorkspaceVariableFactory;
import org.junit.Test;
import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class RepeatTests extends CommandTester {
	@Test
	public void RepeatTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("repeat 10 [ fd 50 ]");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 50);
		
		for(int i=1;i<11;i++){
			DrawableObject line = objectQueue.poll();
			DrawableObject turtle = objectQueue.poll();
			
			assertTrue(turtle.getParent().equals(TurtleFactory.PARENT));
			assertTrue(turtle.getType().equals(TurtleFactory.TYPE));
			assertTrue(turtle.getParameters().get(TurtleFactory.HEADING).equals("0.0"));
			assertTrue(turtle.getParameters().get(TurtleFactory.LOCATION).equals("0.0 " + String.valueOf(50.0*i)));
			
			assertTrue(line.getParent().equals(LineFactory.PARENT));
			assertTrue(line.getType().equals(LineFactory.TYPE));
			assertTrue(line.getParameters().get(LineFactory.ORIGIN).equals("0.0 " + String.valueOf(50.0*(i-1))));
			assertTrue(line.getParameters().get(LineFactory.DESTINATION).equals("0.0 " + String.valueOf(50.0*i)));
		}
		// TODO: implment variable refresh again
//		DrawableObject refreshVariables = objectQueue.poll();
//		
//		assertTrue(refreshVariables.getParent().equals(WorkspaceVariableFactory.PARENT));
//		assertTrue(refreshVariables.getType().equals(WorkspaceVariableFactory.TYPE));
//		assertTrue(refreshVariables.getParameters().size()==0);
//		assertTrue(objectQueue.size()==0);
	}
}

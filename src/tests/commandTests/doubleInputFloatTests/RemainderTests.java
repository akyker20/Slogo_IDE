package tests.commandTests.doubleInputFloatTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;


public class RemainderTests extends CommandTester{

	@Test
	public void IntegerParseTest() throws SLOGOException {
		clearQueue();
		setUpCommands("% 50 7");
		
		CommandParser parser = createCommand();
		float f = parser.parse(commands, objectQueue);
		assertTrue(f == 1);
	}
	
	@Test
	public void FloatParseTest() throws SLOGOException {
		clearQueue();
		setUpCommands("% 50.0 7.0");
		
		CommandParser parser = createCommand();
		float f = parser.parse(commands, objectQueue);
		assertTrue(f == 1);
	}
	
	@Test
	public void IntegerLongParseTest() throws SLOGOException {
		clearQueue();
		setUpCommands("% 7 % 50 9");
		
		CommandParser parser = createCommand();
		float f = parser.parse(commands, objectQueue);
		assertTrue(f == 2);
	}
	
	@Test
	public void IntegerLongerParseTest() throws SLOGOException {
		clearQueue();
		setUpCommands("% 10 % 17 % 11 % 7 % 19 5");
		
		CommandParser parser = createCommand();
		float f = parser.parse(commands, objectQueue);
		assertTrue(f == 0);
	}
	
	@Test
	public void SyntaxErrorParseTest() throws RunTimeNullPointerException {
		clearQueue();
		setUpCommands("% 7 % 50abs 9");
		
		CommandParser parser = createCommand();
		try {
			float f = parser.parse(commands, objectQueue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "50abs" + ". Incorrect syntax."));
		}
	}
	
}
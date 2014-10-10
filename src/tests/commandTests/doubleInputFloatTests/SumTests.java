package tests.commandTests.doubleInputFloatTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;


public class SumTests extends CommandTester{
	
	@Test
	public void IntegerParseTest() throws SLOGOException {
		clearQueue();
		setUpCommands("+ 50 50");
		
		CommandParser parser = createCommand();
		float f = parser.parse(commands, objectQueue);
		assertTrue(f == 100);
	}
	
	@Test
	public void FloatParseTest() throws SLOGOException {
		clearQueue();
		setUpCommands("+ 50.0 50.0");
		
		CommandParser parser = createCommand();
		float f = parser.parse(commands, objectQueue);
		assertTrue(f == 100);
	}
	
	@Test
	public void IntegerLongParseTest() throws SLOGOException {
		clearQueue();
		setUpCommands("+ 50 + 50 50");
		
		CommandParser parser = createCommand();
		float f = parser.parse(commands, objectQueue);
		assertTrue(f == 150);
	}
	
	@Test
	public void IntegerLongerParseTest() throws SLOGOException {
		clearQueue();
		setUpCommands("+ 50 + 50 + 50 + 50 + 50 + 50 50");
		
		CommandParser parser = createCommand();
		float f = parser.parse(commands, objectQueue);
		assertTrue(f == 350);
	}
	
	@Test
	public void SyntaxErrorParseTest() throws RunTimeNullPointerException {
		clearQueue();
		setUpCommands("+ 50 + 5s0 + 50 + 50 + 50 + 50 50");
		
		CommandParser parser = createCommand();
		try {
			float f = parser.parse(commands, objectQueue);		
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "5s0" + ". Incorrect syntax."));
		}

	}
	
}
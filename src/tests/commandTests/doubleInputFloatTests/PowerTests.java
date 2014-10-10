package tests.commandTests.doubleInputFloatTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tests.commandTests.CommandTester;

import commandParsing.CommandParser;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;

public class PowerTests extends CommandTester {
	
	@Test
	public void IntegerParseTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("pow 2 3");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 8);
	}

	@Test
	public void FloatParseTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("pow 2.0 4.0");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 16);
	}
	
	@Test
	public void IntegerLongParseTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("pow 2.0 pow 2.0 3.0");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 256);
	}
	
	@Test
	public void IntegerLongerParseTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("pow 1.0 pow 0.2 pow 10.0 pow 0.1 pow 2.0 2.0");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 1);
	}
	
	@Test
	public void SyntaxErrorParseTest() throws RunTimeNullPointerException {
		resetTesterVariables();
		setUpCommands("pow 50.0 pow 0.2 pow.. 10.0 pow 0.1 pow 10.0 2.0");
		
		CommandParser parser = createCommand();
		try {
			double f = parser.parse(commands, objectQueue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "pow.." + ". Incorrect syntax."));
		}
	}

}

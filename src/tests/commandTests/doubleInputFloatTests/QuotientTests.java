package tests.commandTests.doubleInputFloatTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tests.commandTests.CommandTester;
import commandParsing.CommandParser;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;


public class QuotientTests extends CommandTester{

	@Test
	public void IntegerParseTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("/ 50 2");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 25);
	}
	
	@Test
	public void FloatParseTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("/ 50.0 2.0");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 25);
	}
	
	@Test
	public void IntegerLongParseTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("/ 50 / 50 2");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 2);
	}
	
	@Test
	public void IntegerLongerParseTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("/ 0.4 / 50 / 500 / 20 / 10 / 4 2");
		
		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 1);
	}
	
	@Test
	public void SyntaxErrorParseTest() throws RunTimeNullPointerException {
		resetTesterVariables();
		setUpCommands("/ 50 ..2");
		
		CommandParser parser = createCommand();
		try {
			double f = parser.parse(commands, objectQueue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "..2" + ". Incorrect syntax."));
		}
	}
}

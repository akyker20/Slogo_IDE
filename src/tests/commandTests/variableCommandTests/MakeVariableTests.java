package tests.commandTests.variableCommandTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import tests.commandTests.CommandTester;

public class MakeVariableTests extends CommandTester {
	@Test
	public void MakeTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("set :var 20");

		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 20);		
		assertTrue(objectQueue.size()==0);
		assertTrue(state.fetchVariable(":var") == 20);
	}

	@Test
	public void ComplexMakeTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("set :var sum 20 20");

		CommandParser parser = createCommand();
		double f = parser.parse(commands, objectQueue);
		assertTrue(f == 40);		
		assertTrue(objectQueue.size()==0);
		assertTrue(state.fetchVariable(":var") == 40);		
	}
	
	
	@Test
	public void ManyMakeTest() throws SLOGOException {
		resetTesterVariables();
		setUpCommands("set :var 20 set :varb 25 set :var 25 set :varc 40");

		double f = 0;

		while(commands.hasNext()){
			CommandParser parser = createCommand();
			f = parser.parse(commands, objectQueue);
		}
		assertTrue(f == 40);		
		assertTrue(objectQueue.size()==0);
		assertTrue(state.fetchVariable(":var") == 25);		
		assertTrue(state.fetchVariable(":varb") == 25);	
		assertTrue(state.fetchVariable(":varc") == 40);	
	}

}

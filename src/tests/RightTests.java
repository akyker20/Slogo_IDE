package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import stateUpdate.ParseError;
import stateUpdate.Rotate;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import commandParsing.turtleCommandParsing.Right;
import commandParsing.turtleCommandParsing.TurtleCommand;


public class RightTests {

	@Test
	public void IntegerParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Right", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand rt = (Right) CommandParser.createParser(iterator.next());
			
		rt.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Rotate("50"));
	}
	
	@Test
	public void DoubleParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Right", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand rt = (Right) CommandParser.createParser(iterator.next());
		
		rt.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Rotate("50.0"));
	}
	
	@Test
	public void SumParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Right", "commandParsing.mathCommandParsing."+"Sum", "30.0", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand rt = (Right) CommandParser.createParser(iterator.next());
		
		rt.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Rotate("80.0"));
	}
	
	@Test
	public void SyntaxErrorParsingTest() {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Right", "commandParsing.structuralCommandParsing."+"s", "30.0", "50.0"};
		
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand rt = (Right) CommandParser.createParser(iterator.next());
		
		try {
			rt.parse(iterator, queue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "commandParsing.structuralCommandParsing."+"s" + ". Incorrect syntax."));
		}
	}

}

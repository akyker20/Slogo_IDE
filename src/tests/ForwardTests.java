package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import stateUpdate.Move;
import stateUpdate.StateUpdate;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import commandParsing.turtleCommandParsing.Forward;
import commandParsing.turtleCommandParsing.TurtleCommand;


public class ForwardTests {
	
	@Test
	public void ForwardForwardTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Forward", "commandParsing.turtleCommandParsing."+"Forward", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand fd = (Forward) CommandParser.createParser(iterator.next());
			
		fd.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Move("50"));
		assertEquals(queue.poll(),new Move("50"));
	}

	@Test
	public void IntegerParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Forward", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand fd = (Forward) CommandParser.createParser(iterator.next());
			
		fd.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Move("50"));
	}
	
	@Test
	public void DoubleParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Forward", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand fd = (Forward) CommandParser.createParser(iterator.next());
		
		fd.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Move("50.0"));
	}
	
	@Test
	public void SumParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Forward", "commandParsing.mathCommandParsing."+"Sum", "30.0", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand fd = (Forward) CommandParser.createParser(iterator.next());
		
		fd.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Move("80.0"));
	}
	
	@Test
	public void SyntaxErrorParsingTest() {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Forward", "commandParsing.structuralCommandParsing."+"Isf", "30.0", "50.0"};
		
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand fd = (Forward) CommandParser.createParser(iterator.next());
		
		try {
			fd.parse(iterator, queue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "commandParsing.structuralCommandParsing."+"Isf" + ". Incorrect syntax."));
		}
	}

}

package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import org.junit.Before;
import org.junit.Test;

import stateUpdate.ParseError;
import stateUpdate.Rotate;
import stateUpdate.State;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import commandParsing.turtleCommandParsing.Left;
import commandParsing.turtleCommandParsing.TurtleCommand;


public class LeftTests {
	
	State state;
	
	@Before
	public void setUp() throws Exception {
		state = new State(0.0,Color.BLACK, new Point2D(0,0), new HashMap<String,Float>());
	}

	@Test
	public void IntegerParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Left", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand lt = (Left) CommandParser.createParser(iterator.next(), state);
			
		lt.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Rotate("Difference 0 50"));
	}
	
	@Test
	public void DoubleParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Left", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand lt = (Left) CommandParser.createParser(iterator.next(), state);
		
		lt.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Rotate("Difference 0 50.0"));
	}
	
	@Test
	public void SumParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Left", "commandParsing.mathCommandParsing."+"Sum", "30.0", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand lt = (Left) CommandParser.createParser(iterator.next(), state);
		
		lt.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Rotate("Difference 0 80.0"));
	}
	
	@Test
	public void SyntaxErrorParsingTest() {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Left", "commandParsing.structuralCommandParsing."+"Isf", "30.0", "50.0"};
		
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand lt = (Left) CommandParser.createParser(iterator.next(), state);
		
		try {
			lt.parse(iterator, queue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "commandParsing.structuralCommandParsing."+"Isf" + ". Incorrect syntax."));
		}
	}
}

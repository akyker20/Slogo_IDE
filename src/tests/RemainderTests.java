package tests;

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
import stateUpdate.State;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import commandParsing.mathCommandParsing.MathCommand;
import commandParsing.mathCommandParsing.Remainder;


public class RemainderTests {
	
	State state;
	
	@Before
	public void setUp() throws Exception {
		state = new State(0.0,Color.BLACK, new Point2D(0,0), new HashMap<String,Float>());
	}

	@Test
	public void IntegerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Remainder", "50", "7"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand remainder = (Remainder) CommandParser.createParser(iterator.next(), state);	

		String f = remainder.parse(iterator, queue);
		
		assertTrue(f.equals("1.0"));
	}
	
	@Test
	public void FloatParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Remainder", "50.0", "7.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand remainder = (Remainder) CommandParser.createParser(iterator.next(), state);	

		String f = remainder.parse(iterator, queue);
		
		assertTrue(f.equals("1.0"));
	}
	
	@Test
	public void IntegerLongParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Remainder", "7", "commandParsing.mathCommandParsing."+"Remainder", "50", "9"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand remainder = (Remainder) CommandParser.createParser(iterator.next(), state);	

		String f = remainder.parse(iterator, queue);
		
		assertTrue(f.equals("2.0"));
	}
	
	@Test
	public void IntegerLongerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Remainder", "10", "commandParsing.mathCommandParsing."+"Remainder", "17", "commandParsing.mathCommandParsing."+"Remainder", "11", "commandParsing.mathCommandParsing."+"Remainder", "7", "commandParsing.mathCommandParsing."+"Remainder", "19", "5"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand remainder = (Remainder) CommandParser.createParser(iterator.next(), state);	

		String f = remainder.parse(iterator, queue);
		
		assertTrue(f.equals("0.0"));
	}
	
	@Test
	public void SyntaxErrorParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Remainder", "50", "commandParsing.structuralCommandParsing."+"Isf", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand remainder = (Remainder) CommandParser.createParser(iterator.next(), state);	

		try {
			String f = remainder.parse(iterator, queue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "commandParsing.structuralCommandParsing."+"Isf" + ". Incorrect syntax."));
		}
	}
	
}

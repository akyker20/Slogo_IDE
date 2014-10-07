package tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import stateUpdate.ParseError;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import commandParsing.mathCommandParsing.MathCommand;
import commandParsing.mathCommandParsing.Quotient;


public class QuotientTests {

	@Test
	public void IntegerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Quotient", "50", "25"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next());	

		String f = quotient.parse(iterator, queue);
		
		assertTrue(f.equals("2.0"));
	}
	
	@Test
	public void FloatParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Quotient", "50.0", "25.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next());	

		String f = quotient.parse(iterator, queue);
		
		assertTrue(f.equals("2.0"));
	}
	
	@Test
	public void IntegerLongParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Quotient", "150", "commandParsing.mathCommandParsing."+"Quotient", "50", "25"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next());	

		String f = quotient.parse(iterator, queue);
		
		assertTrue(f.equals("75.0"));
	}
	
	@Test
	public void IntegerLongerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Quotient", "150", "commandParsing.mathCommandParsing."+"Quotient", "50", "commandParsing.mathCommandParsing."+"Quotient", "25", "commandParsing.mathCommandParsing."+"Quotient", "50", "commandParsing.mathCommandParsing."+"Quotient", "50", "25"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next());	

		String f = quotient.parse(iterator, queue);
		
		assertTrue(f.equals("3.0"));
	}
	
	@Test
	public void SyntaxErrorParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Quotient", "50", "commandParsing.structuralCommandParsing."+"Isf", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next());	

		try {
			String f = quotient.parse(iterator, queue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "commandParsing.structuralCommandParsing."+"Isf" + ". Incorrect syntax."));
		}
	}
}

package tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import stateUpdate.StateUpdate;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import commandParsing.mathCommandParsing.Difference;
import commandParsing.mathCommandParsing.MathCommand;


public class DifferenceTests {

	@Test
	public void IntegerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		String f = difference.parse(iterator, queue);

		assertTrue(f.equals("0.0"));
	}

	@Test
	public void FloatParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50.0", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		String f = difference.parse(iterator, queue);

		assertTrue(f.equals("0.0"));
	}

	@Test
	public void IntegerLongParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.mathCommandParsing."+"Difference", "50", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		String f = difference.parse(iterator, queue);

		assertTrue(f.equals("50.0"));
	}

	@Test
	public void IntegerLongerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.mathCommandParsing."+"Difference", "50", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		String f = difference.parse(iterator, queue);

		assertTrue(f.equals("0.0"));
	}

	@Test
	public void SyntaxErrorParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.structuralCommandParsing."+"Isf", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		try {
			String f = difference.parse(iterator, queue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "commandParsing.structuralCommandParsing."+"Isf" + ". Incorrect syntax."));
		}
	}

}

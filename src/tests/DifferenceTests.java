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
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.mathCommandParsing.MathCommand;
import commandParsing.mathCommandParsing.Difference;


public class DifferenceTests {

	@Test
	public void IntegerParseTest() throws CompileTimeParsingException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		String f = difference.parse(iterator, queue);

		assertTrue(f.equals("0.0"));
	}

	@Test
	public void FloatParseTest() throws CompileTimeParsingException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50.0", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		String f = difference.parse(iterator, queue);

		assertTrue(f.equals("0.0"));
	}

	@Test
	public void IntegerLongParseTest() throws CompileTimeParsingException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.mathCommandParsing."+"Difference", "50", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		String f = difference.parse(iterator, queue);

		assertTrue(f.equals("50.0"));
	}

	@Test
	public void IntegerLongerParseTest() throws CompileTimeParsingException {
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
		} catch (CompileTimeParsingException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("commandParsing.structuralCommandParsing."+"Isf"));
		}
	}

}

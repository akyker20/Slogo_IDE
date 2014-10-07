package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import stateUpdate.Move;
import stateUpdate.ParseError;
import stateUpdate.StateUpdate;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.turtleCommandParsing.Backward;
import commandParsing.turtleCommandParsing.TurtleCommand;


public class BackwardTests {


	@Test
	public void IntegerParsingTest() throws CompileTimeParsingException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Backward", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand bk = (Backward) CommandParser.createParser(iterator.next());

		bk.parse(iterator, queue);

		assertEquals(queue.poll(),new Move("Difference 0 50"));
	}

	@Test
	public void DoubleParsingTest() throws CompileTimeParsingException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Backward", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand bk = (Backward) CommandParser.createParser(iterator.next());

		bk.parse(iterator, queue);

		assertEquals(queue.poll(),new Move("Difference 0 50.0"));
	}

	@Test
	public void SumParsingTest() throws CompileTimeParsingException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Backward", "commandParsing.mathCommandParsing."+"Sum", "30.0", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand bk = (Backward) CommandParser.createParser(iterator.next());

		bk.parse(iterator, queue);

		assertEquals(queue.poll(),new Move("Difference 0 80.0"));
	}

	@Test
	public void SyntaxErrorParsingTest() {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Backward", "commandParsing.structuralCommandParsing."+"Isf", "30.0", "50.0"};

		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		TurtleCommand bk = (Backward) CommandParser.createParser(iterator.next());

		try {
			bk.parse(iterator, queue);
		} catch (CompileTimeParsingException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("commandParsing.structuralCommandParsing."+"Isf"));
		}
	}

}

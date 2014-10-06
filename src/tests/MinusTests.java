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
import commandParsing.mathCommandParsing.MathCommand;
import commandParsing.mathCommandParsing.Difference;


public class MinusTests {

	@Test
	public void IntegerParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		float f = difference.parse(iterator, queue);
		
		assertTrue(f==(float) 0);
	}
	
	@Test
	public void FloatParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50.0", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		float f = difference.parse(iterator, queue);
		
		assertTrue(f==(float) 0);
	}
	
	@Test
	public void IntegerLongParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.mathCommandParsing."+"Difference", "50", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		float f = difference.parse(iterator, queue);
		
		assertTrue(f==(float) 50);
	}
	
	@Test
	public void IntegerLongerParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.mathCommandParsing."+"Difference", "50", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		float f = difference.parse(iterator, queue);
		
		assertTrue(f==(float) 0);
	}
	
	@Test
	public void SyntaxErrorParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Difference", "50", "commandParsing.structuralCommandParsing."+"Isf", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand difference = (Difference) CommandParser.createParser(iterator.next());	

		float f = difference.parse(iterator, queue);
		
		assertTrue(queue.contains(new ParseError()));
	}
	
}

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
import commandParsing.mathCommandParsing.Product;


public class ProductTests {

	@Test
	public void IntegerParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "50", "2"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next());	

		float f = product.parse(iterator, queue);
		
		assertTrue(f==(float) 100);
	}
	
	@Test
	public void FloatParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "50.0", "2.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next());	

		float f = product.parse(iterator, queue);
		
		assertTrue(f==(float) 100);
	}
	
	@Test
	public void IntegerLongParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "7", "commandParsing.mathCommandParsing."+"Product", "50", "10"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next());	

		float f = product.parse(iterator, queue);

		assertTrue(f==(float) 3500);
	}
	
	@Test
	public void IntegerLongerParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "0.2", "commandParsing.mathCommandParsing."+"Product", "0.5", "commandParsing.mathCommandParsing."+"Product", "2", "commandParsing.mathCommandParsing."+"Product", "10", "commandParsing.mathCommandParsing."+"Product", "5", "5"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next());	

		float f = product.parse(iterator, queue);
		
		assertTrue(f==(float) 50);
	}
	
	@Test
	public void SyntaxErrorParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "50", "commandParsing.structuralCommandParsing."+"Isf", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next());	

		float f = product.parse(iterator, queue);
		
		assertTrue(queue.contains(new ParseError()));
	}
	
}

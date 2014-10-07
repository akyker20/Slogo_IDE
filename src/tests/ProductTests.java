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
import commandParsing.mathCommandParsing.Product;


public class ProductTests {

	@Test
	public void IntegerParseTest() throws CompileTimeParsingException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "50", "2"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next());	

		String f = product.parse(iterator, queue);
		
		assertTrue(f.equals("100.0"));
	}
	
	@Test
	public void FloatParseTest() throws CompileTimeParsingException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "50.0", "2.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next());	

		String f = product.parse(iterator, queue);
		
		assertTrue(f.equals("100.0"));
	}
	
	@Test
	public void IntegerLongParseTest() throws CompileTimeParsingException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "7", "commandParsing.mathCommandParsing."+"Product", "50", "10"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next());	

		String f = product.parse(iterator, queue);

		assertTrue(f.equals("3500.0"));
	}
	
	@Test
	public void IntegerLongerParseTest() throws CompileTimeParsingException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "0.2", "commandParsing.mathCommandParsing."+"Product", "0.5", "commandParsing.mathCommandParsing."+"Product", "2", "commandParsing.mathCommandParsing."+"Product", "10", "commandParsing.mathCommandParsing."+"Product", "5", "5"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next());	

		String f = product.parse(iterator, queue);
		
		assertTrue(f.equals("50.0"));
	}
	
	@Test
	public void SyntaxErrorParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "50", "commandParsing.structuralCommandParsing."+"Isf", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next());	

		try {
			String f = product.parse(iterator, queue);
		} catch (CompileTimeParsingException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("commandParsing.structuralCommandParsing."+"Isf"));
		}
	}
	
}

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

import stateUpdate.State;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import commandParsing.mathCommandParsing.MathCommand;
import commandParsing.mathCommandParsing.Product;

import drawableobject.DrawableObject;


public class ProductTests {
	
	State state;
	
	@Before
	public void setUp() throws Exception {
		state = new State((float) 0.0,Color.BLACK, new Point2D(0,0), new HashMap<String,Float>());
	}

	@Test
	public void IntegerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "50", "2"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next(), state);	

		float f = product.parse(iterator, queue);
		
		assertTrue(f == 100);
	}
	
	@Test
	public void FloatParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "50.0", "2.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next(), state);	

		float f = product.parse(iterator, queue);
		
		assertTrue(f == 100);
	}
	
	@Test
	public void IntegerLongParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "7", "commandParsing.mathCommandParsing."+"Product", "50", "10"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next(), state);	

		float f = product.parse(iterator, queue);

		assertTrue(f == 3500);
	}
	
	@Test
	public void IntegerLongerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "0.2", "commandParsing.mathCommandParsing."+"Product", "0.5", "commandParsing.mathCommandParsing."+"Product", "2", "commandParsing.mathCommandParsing."+"Product", "10", "commandParsing.mathCommandParsing."+"Product", "5", "5"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next(), state);	

		float f = product.parse(iterator, queue);
		
		assertTrue(f == 50);
	}
	
	@Test
	public void SyntaxErrorParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Product", "50", "commandParsing.structuralCommandParsing."+"Isf", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand product = (Product) CommandParser.createParser(iterator.next(), state);	

		try {
			float f = product.parse(iterator, queue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "commandParsing.structuralCommandParsing."+"Isf" + ". Incorrect syntax."));
		}
	}
	
}

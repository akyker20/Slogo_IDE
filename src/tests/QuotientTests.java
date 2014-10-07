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
import commandParsing.mathCommandParsing.Quotient;

import drawableobject.DrawableObject;


public class QuotientTests {
	
	State state;
	
	@Before
	public void setUp() throws Exception {
		state = new State((float) 0.0,Color.BLACK, new Point2D(0,0), new HashMap<String,Float>());
	}

	@Test
	public void IntegerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Quotient", "50", "25"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next(), state);	

		float f = quotient.parse(iterator, queue);
		
		assertTrue(f == 2);
	}
	
	@Test
	public void FloatParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Quotient", "50.0", "25.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next(), state);	

		float f = quotient.parse(iterator, queue);
		
		assertTrue(f == 2);
	}
	
	@Test
	public void IntegerLongParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Quotient", "150", "commandParsing.mathCommandParsing."+"Quotient", "50", "25"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next(), state);	

		float f = quotient.parse(iterator, queue);
		
		assertTrue(f == 75);
	}
	
	@Test
	public void IntegerLongerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Quotient", "150", "commandParsing.mathCommandParsing."+"Quotient", "50", "commandParsing.mathCommandParsing."+"Quotient", "25", "commandParsing.mathCommandParsing."+"Quotient", "50", "commandParsing.mathCommandParsing."+"Quotient", "50", "25"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next(), state);	

		float f = quotient.parse(iterator, queue);
		
		assertTrue(f == 3);
	}
	
	@Test
	public void SyntaxErrorParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Quotient", "50", "commandParsing.structuralCommandParsing."+"Isf", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next(), state);	

		try {
			float f = quotient.parse(iterator, queue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "commandParsing.structuralCommandParsing."+"Isf" + ". Incorrect syntax."));
		}
	}
}

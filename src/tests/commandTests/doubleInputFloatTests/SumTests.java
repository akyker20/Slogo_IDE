package tests.commandTests.doubleInputFloatTests;

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
import commandParsing.mathCommandParsing.Sum;

import drawableobject.DrawableObject;


public class SumTests {
	
	State state;
	
	@Before
	public void setUp() throws Exception {
		state = new State((float) 0.0,Color.BLACK, new Point2D(0,0), new HashMap<String,Float>());
	}
	
	@Test
	public void IntegerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Sum", "50", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand sum = (Sum) CommandParser.createParser(iterator.next(), state);	

		float f = sum.parse(iterator, queue);
		
		assertTrue(f == 100);
	}
	
	@Test
	public void FloatParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Sum", "50.0", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand sum = (Sum) CommandParser.createParser(iterator.next(), state);	

		float f = sum.parse(iterator, queue);
		
		assertTrue(f == 100);
	}
	
	@Test
	public void IntegerLongParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Sum", "50", "commandParsing.mathCommandParsing."+"Sum", "50", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand sum = (Sum) CommandParser.createParser(iterator.next(), state);	

		float f = sum.parse(iterator, queue);
		
		assertTrue(f == 150);
	}
	
	@Test
	public void IntegerLongerParseTest() throws SLOGOException {
		String[] commands = {"commandParsing.mathCommandParsing."+"Sum", "50", "commandParsing.mathCommandParsing."+"Sum", "50", "commandParsing.mathCommandParsing."+"Sum", "50", "commandParsing.mathCommandParsing."+"Sum", "50", "commandParsing.mathCommandParsing."+"Sum", "50", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand sum = (Sum) CommandParser.createParser(iterator.next(), state);	

		float f = sum.parse(iterator, queue);
		
		assertTrue(f == 300);
	}
	
	@Test
	public void SyntaxErrorParseTest() {
		String[] commands = {"commandParsing.mathCommandParsing."+"Sum", "50", "commandParsing.structuralCommandParsing."+"Isf", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		MathCommand sum = (Sum) CommandParser.createParser(iterator.next(), state);	

		try {
			float f = sum.parse(iterator, queue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "commandParsing.structuralCommandParsing."+"Isf" + ". Incorrect syntax."));
		}

	}
	
}

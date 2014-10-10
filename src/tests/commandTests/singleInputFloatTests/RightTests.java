package tests.commandTests.singleInputFloatTests;

import static org.junit.Assert.assertEquals;
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

import state.Rotate;
import state.State;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import commandParsing.turtleCommandParsing.Right;
import commandParsing.turtleCommandParsing.TurtleCommand;
import drawableobject.DrawableObject;


public class RightTests {
	
	State state;
	
	@Before
	public void setUp() throws Exception {
		state = new State((float) 0.0,Color.BLACK, new Point2D(0,0), new HashMap<String,Float>());
	}

	@Test
	public void IntegerParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Right", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		TurtleCommand rt = (Right) CommandParser.createParser(iterator.next(), state);
			
		rt.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Rotate("50"));
	}
	
	@Test
	public void DoubleParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Right", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		TurtleCommand rt = (Right) CommandParser.createParser(iterator.next(), state);
		
		rt.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Rotate("50.0"));
	}
	
	@Test
	public void SumParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Right", "commandParsing.mathCommandParsing."+"Sum", "30.0", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		TurtleCommand rt = (Right) CommandParser.createParser(iterator.next(), state);
		
		rt.parse(iterator, queue);
		
		assertEquals(queue.poll(),new Rotate("80.0"));
	}
	
	@Test
	public void SyntaxErrorParsingTest() {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Right", "commandParsing.structuralCommandParsing."+"s", "30.0", "50.0"};
		
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		TurtleCommand rt = (Right) CommandParser.createParser(iterator.next(), state);
		
		try {
			rt.parse(iterator, queue);
		} catch (SLOGOException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "commandParsing.structuralCommandParsing."+"s" + ". Incorrect syntax."));
		}
	}

}

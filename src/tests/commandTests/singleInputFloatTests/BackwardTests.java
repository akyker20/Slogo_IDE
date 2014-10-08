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

import stateUpdate.Move;
import stateUpdate.State;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;
import commandParsing.turtleCommandParsing.Backward;
import commandParsing.turtleCommandParsing.TurtleCommand;
import drawableobject.DrawableObject;


public class BackwardTests {

	@Test
	public void IntegerParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Backward", "50"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		TurtleCommand bk = (Backward) CommandParser.createParser(iterator.next(), state);

		bk.parse(iterator, queue);

		assertEquals(queue.poll(),new Move("Difference 0 50"));
	}

	@Test
	public void DoubleParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Backward", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		TurtleCommand bk = (Backward) CommandParser.createParser(iterator.next(), state);

		bk.parse(iterator, queue);

		assertEquals(queue.poll(),new Move("Difference 0 50.0"));
	}

	@Test
	public void SumParsingTest() throws SLOGOException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Backward", "commandParsing.mathCommandParsing."+"Sum", "30.0", "50.0"};
		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		TurtleCommand bk = (Backward) CommandParser.createParser(iterator.next(), state);

		bk.parse(iterator, queue);

		assertEquals(queue.poll(),new Move("Difference 0 80.0"));
	}

	@Test
	public void SyntaxErrorParsingTest() throws RunTimeDivideByZeroException, RunTimeNullPointerException {
		String[] commands = {"commandParsing.turtleCommandParsing."+"Backward", "commandParsing.structuralCommandParsing."+"Isf", "30.0", "50.0"};

		Iterator<String> iterator = Arrays.asList(commands).iterator();
		Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
		TurtleCommand bk = (Backward) CommandParser.createParser(iterator.next(), state);

		try {
			bk.parse(iterator, queue);
		} catch (CompileTimeParsingException e) {
			assertTrue(e.generateErrorMessage().getParameters().values().contains("Error parsing following string: " + "commandParsing.structuralCommandParsing."+"Isf" + ". Incorrect syntax."));
		}
	}

}

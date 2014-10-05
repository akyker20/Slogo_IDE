package api.tests;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;
import api.classes.CommandParser;
import api.classes.ParseError;
import api.classes.StateUpdate;
import api.classes.TurtleCommand;


public class LeftTests {

    @Test
    public void IntegerParsingTest () {
        String[] commands = { "commandParsing.turtleCommandParsing." + "Left", "50" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        TurtleCommand lt = (Left) CommandParser.createParser(iterator.next());

        lt.parse(iterator, queue);

        assertEquals(queue.poll(), new Rotate(-50));
    }

    @Test
    public void DoubleParsingTest () {
        String[] commands = { "commandParsing.turtleCommandParsing." + "Left", "50.0" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        TurtleCommand lt = (Left) CommandParser.createParser(iterator.next());

        lt.parse(iterator, queue);

        assertEquals(queue.poll(), new Rotate(-50));
    }

    @Test
    public void SumParsingTest () {
        String[] commands =
            { "commandParsing.turtleCommandParsing." + "Left",
              "commandParsing.mathCommandParsing." + "Sum", "30.0", "50.0" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        TurtleCommand lt = (Left) CommandParser.createParser(iterator.next());

        lt.parse(iterator, queue);

        assertEquals(queue.poll(), new Rotate(-80));
    }

    @Test
    public void SyntaxErrorParsingTest () {
        String[] commands =
            { "commandParsing.turtleCommandParsing." + "Left",
              "commandParsing.structuralCommandParsing." + "If", "30.0", "50.0" };

        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        TurtleCommand lt = (Left) CommandParser.createParser(iterator.next());

        lt.parse(iterator, queue);

        assertEquals(queue.poll(), new ParseError());
    }
}

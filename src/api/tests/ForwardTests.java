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


public class ForwardTests {

    @Test
    public void IntegerParsingTest () {
        String[] commands = { "commandParsing.turtleCommandParsing." + "Forward", "50" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        TurtleCommand fd = (Forward) CommandParser.createParser(iterator.next());

        fd.parse(iterator, queue);

        assertEquals(queue.poll(), new Move(50));
    }

    @Test
    public void DoubleParsingTest () {
        String[] commands = { "commandParsing.turtleCommandParsing." + "Forward", "50.0" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        TurtleCommand fd = (Forward) CommandParser.createParser(iterator.next());

        fd.parse(iterator, queue);

        assertEquals(queue.poll(), new Move(50));
    }

    @Test
    public void SumParsingTest () {
        String[] commands =
            { "commandParsing.turtleCommandParsing." + "Forward",
              "commandParsing.mathCommandParsing." + "Sum", "30.0", "50.0" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        TurtleCommand fd = (Forward) CommandParser.createParser(iterator.next());

        fd.parse(iterator, queue);

        assertEquals(queue.poll(), new Move(80));
    }

    @Test
    public void SyntaxErrorParsingTest () {
        String[] commands =
            { "commandParsing.turtleCommandParsing." + "Forward",
              "commandParsing.structuralCommandParsing." + "If", "30.0", "50.0" };

        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        TurtleCommand fd = (Forward) CommandParser.createParser(iterator.next());

        fd.parse(iterator, queue);

        assertEquals(queue.poll(), new ParseError());
    }

}
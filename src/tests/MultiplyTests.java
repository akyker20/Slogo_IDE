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
import commandParsing.mathCommandParsing.Multiply;


public class MultiplyTests {

    @Test
    public void IntegerParseTest () {
        String[] commands = { "commandParsing.mathCommandParsing." + "Multiply", "50", "2" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand multiply = (Multiply) CommandParser.createParser(iterator.next());

        float f = multiply.parse(iterator, queue);

        assertTrue(f == 100);
    }

    @Test
    public void FloatParseTest () {
        String[] commands = { "commandParsing.mathCommandParsing." + "Multiply", "50.0", "2.0" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand multiply = (Multiply) CommandParser.createParser(iterator.next());

        float f = multiply.parse(iterator, queue);

        assertTrue(f == 100);
    }

    @Test
    public void IntegerLongParseTest () {
        String[] commands =
                { "commandParsing.mathCommandParsing." + "Multiply", "7",
                 "commandParsing.mathCommandParsing." + "Multiply", "50", "10" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand multiply = (Multiply) CommandParser.createParser(iterator.next());

        float f = multiply.parse(iterator, queue);

        assertTrue(f == 3500);
    }

    @Test
    public void IntegerLongerParseTest () {
        String[] commands =
                { "commandParsing.mathCommandParsing." + "Multiply", "0.2",
                 "commandParsing.mathCommandParsing." + "Multiply", "0.5",
                 "commandParsing.mathCommandParsing." + "Multiply", "2",
                 "commandParsing.mathCommandParsing." + "Multiply", "10",
                 "commandParsing.mathCommandParsing." + "Multiply", "5", "5" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand multiply = (Multiply) CommandParser.createParser(iterator.next());

        float f = multiply.parse(iterator, queue);

        assertTrue(f == 50);
    }

    @Test
    public void SyntaxErrorParseTest () {
        String[] commands =
                { "commandParsing.mathCommandParsing." + "Multiply", "50",
                 "commandParsing.structuralCommandParsing." + "If", "50" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand multiply = (Multiply) CommandParser.createParser(iterator.next());

        multiply.parse(iterator, queue);

        assertTrue(queue.contains(new ParseError()));
    }

}

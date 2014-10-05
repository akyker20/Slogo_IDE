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
import commandParsing.mathCommandParsing.Sum;


public class SumTests {

    @Test
    public void IntegerParseTest () {
        String[] commands = { "commandParsing.mathCommandParsing." + "Sum", "50", "50" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand sum = (Sum) CommandParser.createParser(iterator.next());

        float f = sum.parse(iterator, queue);

        assertTrue(f == 100);
    }

    @Test
    public void FloatParseTest () {
        String[] commands = { "commandParsing.mathCommandParsing." + "Sum", "50.0", "50.0" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand sum = (Sum) CommandParser.createParser(iterator.next());

        float f = sum.parse(iterator, queue);

        assertTrue(f == 100);
    }

    @Test
    public void IntegerLongParseTest () {
        String[] commands =
            { "commandParsing.mathCommandParsing." + "Sum", "50",
              "commandParsing.mathCommandParsing." + "Sum", "50", "50" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand sum = (Sum) CommandParser.createParser(iterator.next());

        float f = sum.parse(iterator, queue);

        assertTrue(f == 150);
    }

    @Test
    public void IntegerLongerParseTest () {
        String[] commands =
            { "commandParsing.mathCommandParsing." + "Sum", "50",
              "commandParsing.mathCommandParsing." + "Sum", "50",
              "commandParsing.mathCommandParsing." + "Sum", "50",
              "commandParsing.mathCommandParsing." + "Sum", "50",
              "commandParsing.mathCommandParsing." + "Sum", "50", "50" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand sum = (Sum) CommandParser.createParser(iterator.next());

        float f = sum.parse(iterator, queue);

        assertTrue(f == 300);
    }

    @Test
    public void SyntaxErrorParseTest () {
        String[] commands =
            { "commandParsing.mathCommandParsing." + "Sum", "50",
              "commandParsing.structuralCommandParsing." + "If", "50" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand sum = (Sum) CommandParser.createParser(iterator.next());

        sum.parse(iterator, queue);

        assertTrue(queue.contains(new ParseError()));
    }

}

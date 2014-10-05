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
import commandParsing.mathCommandParsing.Quotient;


public class QuotientTests {

    @Test
    public void IntegerParseTest () {
        String[] commands = { "commandParsing.mathCommandParsing." + "Quotient", "50", "25" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next());

        float f = quotient.parse(iterator, queue);

        assertTrue(f == 2);
    }

    @Test
    public void FloatParseTest () {
        String[] commands = { "commandParsing.mathCommandParsing." + "Quotient", "50.0", "25.0" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next());

        float f = quotient.parse(iterator, queue);

        assertTrue(f == 2);
    }

    @Test
    public void IntegerLongParseTest () {
        String[] commands =

            { "commandParsing.mathCommandParsing." + "Quotient", "150",
              "commandParsing.mathCommandParsing." + "Quotient", "50", "25" };

        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next());

        float f = quotient.parse(iterator, queue);

        assertTrue(f == 75);
    }

    @Test
    public void IntegerLongerParseTest () {
        String[] commands =

            { "commandParsing.mathCommandParsing." + "Quotient", "150",
              "commandParsing.mathCommandParsing." + "Quotient", "50",
              "commandParsing.mathCommandParsing." + "Quotient", "25",
              "commandParsing.mathCommandParsing." + "Quotient", "50",
              "commandParsing.mathCommandParsing." + "Quotient", "50", "25" };

        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next());

        float f = quotient.parse(iterator, queue);

        assertTrue(f == 3);
    }

    @Test
    public void SyntaxErrorParseTest () {
        String[] commands =

            { "commandParsing.mathCommandParsing." + "Quotient", "50",
              "commandParsing.structuralCommandParsing." + "If", "50" };

        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand quotient = (Quotient) CommandParser.createParser(iterator.next());

        quotient.parse(iterator, queue);

        assertTrue(queue.contains(new ParseError()));
    }

}

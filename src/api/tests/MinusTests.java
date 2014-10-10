package api.tests;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;
import api.classes.CommandParser;
import api.classes.MathCommand;
import api.classes.ParseError;
import api.classes.StateUpdate;


public class MinusTests {

    @Test
    public void IntegerParseTest () {
        String[] commands = { "commandParsing.mathCommandParsing." + "Minus", "50", "50" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand minus = (Minus) CommandParser.createParser(iterator.next());

        double f = minus.parse(iterator, queue);

        assertTrue(f == 0);
    }

    @Test
    public void FloatParseTest () {
        String[] commands = { "commandParsing.mathCommandParsing." + "Minus", "50.0", "50.0" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand minus = (Minus) CommandParser.createParser(iterator.next());

        double f = minus.parse(iterator, queue);

        assertTrue(f == 0);
    }

    @Test
    public void IntegerLongParseTest () {
        String[] commands =
            { "commandParsing.mathCommandParsing." + "Minus", "50",
              "commandParsing.mathCommandParsing." + "Minus", "50", "50" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand minus = (Minus) CommandParser.createParser(iterator.next());

        double f = minus.parse(iterator, queue);

        assertTrue(f == 50);
    }

    @Test
    public void IntegerLongerParseTest () {
        String[] commands =
            { "commandParsing.mathCommandParsing." + "Minus", "50",
              "commandParsing.mathCommandParsing." + "Minus", "50",
              "commandParsing.mathCommandParsing." + "Minus", "50",
              "commandParsing.mathCommandParsing." + "Minus", "50",
              "commandParsing.mathCommandParsing." + "Minus", "50", "50" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand minus = (Minus) CommandParser.createParser(iterator.next());

        double f = minus.parse(iterator, queue);

        assertTrue(f == 0);
    }

    @Test
    public void SyntaxErrorParseTest () {
        String[] commands =
            { "commandParsing.mathCommandParsing." + "Minus", "50",
              "commandParsing.structuralCommandParsing." + "If", "50" };
        Iterator<String> iterator = Arrays.asList(commands).iterator();
        Queue<StateUpdate> queue = new LinkedList<StateUpdate>();
        MathCommand minus = (Minus) CommandParser.createParser(iterator.next());

        minus.parse(iterator, queue);

        assertTrue(queue.contains(new ParseError()));
    }

}

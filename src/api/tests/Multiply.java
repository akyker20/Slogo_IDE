package api.tests;

import java.util.Iterator;
import java.util.Queue;
import api.classes.MathCommand;
import api.classes.StateUpdate;


public class Multiply extends MathCommand {

    @Override
    public double parse (Iterator<String> commandString, Queue<StateUpdate> updateQueue) {
        return 0;
    }

}

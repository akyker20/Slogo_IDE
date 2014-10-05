package gui.turtle;

public class Turtle {
    private TurtleState myState;

    public Turtle () {
        myState = new TurtleState();
    }

    public TurtleState getState () {
        return myState;
    }
}

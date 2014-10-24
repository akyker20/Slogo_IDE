package commandParsing.turtleCommandParsing;

import state.State;

public class Backward extends Move {
	public Backward(State someState) {
		super(someState);
	}

	@Override
	protected double distanceToMove(double distance) {
		return -distance;
	}
}
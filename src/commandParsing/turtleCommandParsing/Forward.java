package commandParsing.turtleCommandParsing;

import state.State;

public class Forward extends Move {
	public Forward(State someState) {
		super(someState);
	}

	@Override
	protected double distanceToMove(double distance) {
		return distance;
	}
}
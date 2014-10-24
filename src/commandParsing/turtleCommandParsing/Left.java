package commandParsing.turtleCommandParsing;

import state.State;

public class Left extends Rotate {

	public Left(State someState) {
		super(someState);
	}

	@Override
	protected double amountToRotate(double rotation) {
		return -rotation;
	}
}

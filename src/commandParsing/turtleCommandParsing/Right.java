package commandParsing.turtleCommandParsing;

import state.State;

public class Right extends Rotate {

	public Right(State someState) {
		super(someState);
	}

	@Override
	protected double amountToRotate(double rotation) {
		return rotation;
	}
}

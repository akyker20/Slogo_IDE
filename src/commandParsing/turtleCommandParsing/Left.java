package commandParsing.turtleCommandParsing;

public class Left extends Rotate {

	@Override
	protected double amountToRotate(double rotation) {
		return -rotation;
	}
}

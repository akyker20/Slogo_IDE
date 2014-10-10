package commandParsing.turtleCommandParsing;

public class Right extends Rotate {

	@Override
	protected double amountToRotate(double rotation) {
		return rotation;
	}
}

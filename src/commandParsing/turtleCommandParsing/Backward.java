package commandParsing.turtleCommandParsing;

public class Backward extends Move {
	@Override
	protected double distanceToMove(double distance) {
		return -distance;
	}
}
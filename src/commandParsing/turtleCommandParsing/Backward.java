package commandParsing.turtleCommandParsing;

import workspace.Workspace;

public class Backward extends Move {
	public Backward(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double distanceToMove(double distance) {
		return -distance;
	}
}
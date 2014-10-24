package commandParsing.turtleCommandParsing;

import workspace.Workspace;

public class Forward extends Move {
	public Forward(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double distanceToMove(double distance) {
		return distance;
	}
}
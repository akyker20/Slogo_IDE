package commandParsing.turtleCommandParsing;

import workspace.Workspace;

public class Left extends Rotate {

	public Left(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double amountToRotate(double rotation) {
		return -rotation;
	}
}

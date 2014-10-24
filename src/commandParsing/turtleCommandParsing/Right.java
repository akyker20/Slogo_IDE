package commandParsing.turtleCommandParsing;

import workspace.Workspace;

public class Right extends Rotate {

	public Right(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double amountToRotate(double rotation) {
		return rotation;
	}
}

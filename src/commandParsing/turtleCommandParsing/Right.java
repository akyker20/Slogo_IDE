package commandParsing.turtleCommandParsing;

import workspaceState.WorkspaceState;

public class Right extends Rotate {

	public Right(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double amountToRotate(double rotation) {
		return rotation;
	}
}

package commandParsing.turtleCommandParsing.turtleMovement;

import workspaceState.WorkspaceState;


public class Left extends Rotate {

    public Left (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    protected double amountToRotate (double rotation) {
        return -rotation;
    }
}

package commandParsing.turtleCommandParsing.turtleMovement;

import workspaceState.WorkspaceState;


public class Backward extends Move {
    public Backward (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    protected double distanceToMove (double distance) {
        return -distance;
    }
}

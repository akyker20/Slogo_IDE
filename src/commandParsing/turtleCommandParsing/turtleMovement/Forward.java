package commandParsing.turtleCommandParsing.turtleMovement;

import workspaceState.WorkspaceState;


public class Forward extends Move {
    public Forward (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    protected double distanceToMove (double distance) {
        return distance;
    }
}

package commandParsing.turtleCommandParsing.turtleMovement;

import workspaceState.WorkspaceState;

//This entire file is part of my masterpiece.
//Steve Kuznetsov

public class Forward extends Move {
    public Forward (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    protected double distanceToMove (double distance) {
        return distance;
    }
}

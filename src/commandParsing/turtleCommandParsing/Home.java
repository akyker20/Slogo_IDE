package commandParsing.turtleCommandParsing;

import java.util.List;

import workspaceState.Location;
import workspaceState.WorkspaceState;

public class Home extends MoveToLocation {

	public Home(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected int getNumberOfArguments() {
		return 0;
	}

	@Override
	protected Location getDestinationLocation(List<Double> components) {
		return new Location(0, 0);
	}

	@Override
	protected double getDestinationHeading(WorkspaceState workspace) {
		return -workspace.turtles.getLastActiveTurtle().getHeading();
	}

}

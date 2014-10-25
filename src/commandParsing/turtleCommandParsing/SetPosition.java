package commandParsing.turtleCommandParsing;

import java.util.List;

import workspaceState.Location;
import workspaceState.WorkspaceState;

public class SetPosition extends MoveToLocation {

	public SetPosition(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected Location getDestinationLocation(List<Double> components) {
		return new Location(components.get(0), components.get(1));
	}

	@Override
	protected double getDestinationHeading(WorkspaceState workspace) {
		return 0;
	}
}

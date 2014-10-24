package commandParsing.turtleCommandParsing;

import java.util.List;

import workspace.Location;
import workspace.Workspace;

public class SetPosition extends MoveToLocation {
	
	public SetPosition(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected Location getDestinationLocation(List<Double> components) {
		return new Location(components.get(0),components.get(1));
	}

	@Override
	protected double getDestinationHeading(Workspace workspace) {
		return 0;
	}
}

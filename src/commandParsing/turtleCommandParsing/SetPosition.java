package commandParsing.turtleCommandParsing;

import java.util.List;

import state.Location;
import state.Workspace;

public class SetPosition extends MoveToLocation {
	
	@Override
	protected Location getDestinationLocation(List<Double> components) {
		return new Location(components.get(0),components.get(1));
	}

	@Override
	protected double getDestinationHeading(Workspace state) {
		return 0;
	}
}

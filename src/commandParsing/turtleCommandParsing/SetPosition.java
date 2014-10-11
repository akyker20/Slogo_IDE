package commandParsing.turtleCommandParsing;

import java.util.List;

import state.Location;
import state.State;

public class SetPosition extends MoveToLocation {
	
	@Override
	protected Location getDestinationLocation(List<Double> components) {
		return new Location(components.get(0),components.get(1));
	}

	@Override
	protected double getDestinationHeading(State state) {
		return 0;
	}
}

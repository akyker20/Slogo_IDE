package commandParsing.turtleCommandParsing;

import java.util.List;

import state.Location;
import state.State;

public class Home extends MoveToLocation {
	
	@Override
	protected int getNumberOfArguments() {
		return 0;
	}

	@Override
	protected Location getDestinationLocation(List<Double> components) {
		return new Location(0,0);
	}

	@Override
	protected double getDestinationHeading(State state) {
		return -state.getHeading();
	}

}

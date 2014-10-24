package commandParsing.turtleCommandParsing;

import java.util.List;

import state.Location;
import state.Workspace;

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
	protected double getDestinationHeading(Workspace state) {
		return -state.turtles.getLastActiveTurtle().getHeading();
	}

}

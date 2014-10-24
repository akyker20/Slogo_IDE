package commandParsing.turtleCommandParsing;

import java.util.List;

import workspace.Location;
import workspace.Workspace;

public class Home extends MoveToLocation {
	
	public Home(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected int getNumberOfArguments() {
		return 0;
	}

	@Override
	protected Location getDestinationLocation(List<Double> components) {
		return new Location(0,0);
	}

	@Override
	protected double getDestinationHeading(Workspace workspace) {
		return -workspace.turtles.getLastActiveTurtle().getHeading();
	}

}

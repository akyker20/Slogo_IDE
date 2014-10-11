package gui.factories;

import gui.componentdrawers.GridDrawer;

import java.util.Arrays;

public class GridEdgeRules {

	public static double[] applyRules(double[] origin, double[] destination) {

		if ((leftBorderReached(destination[0])
				|| rightBorderReached(destination[0])
				|| topBorderReached(destination[1]) || bottomBorderReached(destination[1]))) {

			return computeNewDestination(origin, destination);
		} else {
			return destination;
		}
	}

	public static double[] computeNewDestination(double[] origin,
			double[] destination) {
		double[] newLocation = new double[2];
		double slope = (origin[1] - destination[1])
				/ (origin[0] - destination[0]);

		if (rightBorderReached(destination[0])) {
			newLocation[0] = GridDrawer.GRID_WIDTH / 2;
			newLocation[1] = (origin[0] - GridDrawer.GRID_WIDTH / 2) * slope;

		}
		if (leftBorderReached(destination[0])) {
			newLocation[0] = -GridDrawer.GRID_WIDTH / 2;
			newLocation[1] = (origin[0] + GridDrawer.GRID_WIDTH / 2) * slope;
		}
		if (topBorderReached(destination[1])) {
			newLocation[1] = GridDrawer.GRID_HEIGHT / 2;
			newLocation[0] = (origin[1] - GridDrawer.GRID_HEIGHT / 2) / slope;

		}
		if (bottomBorderReached(destination[1])) {
			newLocation[1] = -GridDrawer.GRID_WIDTH / 2;
			newLocation[0] = (origin[1] + GridDrawer.GRID_WIDTH / 2) / slope;
		}
		return newLocation;
	}

	private static boolean topBorderReached(double yLoc) {

		return (GridDrawer.GRID_HEIGHT / 2 - yLoc) <= 0;
	}

	private static boolean bottomBorderReached(double yLoc) {
		return (GridDrawer.GRID_HEIGHT / 2 - yLoc) >= GridDrawer.GRID_HEIGHT;
	}

	private static boolean leftBorderReached(double xLoc) {
		return (xLoc + GridDrawer.GRID_WIDTH / 2) <= 0;
	}

	private static boolean rightBorderReached(double xLoc) {
		return (xLoc + GridDrawer.GRID_WIDTH / 2) >= GridDrawer.GRID_WIDTH;
	}
}

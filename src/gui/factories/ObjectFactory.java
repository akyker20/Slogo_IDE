package gui.factories;

import gui.componentdrawers.GridDrawer;

import java.util.Map;

import javafx.scene.Node;

/**
 * Class to generate objects that will be drawn in a component
 *
 * @author akyker20, allankiplagat
 *
 */

public abstract class ObjectFactory {

	private String myName;

	public ObjectFactory(String name) {
		myName = name;
	}

	/**
	 * Generates a Node based on the input parameters
	 *
	 * @param params
	 * @return
	 */
	public abstract Node generateObject(Map<String, String> params);

	/**
	 * Returns the name of the factory assigned to the constructor This method
	 * will be used in the DrawableObjectParser class to parse the correct
	 * factory to generate an object
	 *
	 * @return
	 */

	@Override
	public String toString() {
		return myName;
	}

	public double[] outOfBoundsStopper(double[] destination) {
		if (destination[0] + GridDrawer.GRID_WIDTH / 2 < 0
				|| destination[0] + GridDrawer.GRID_WIDTH / 2 > GridDrawer.GRID_WIDTH) {
			destination[0] = GridDrawer.GRID_WIDTH;
		}
		if (destination[1] + GridDrawer.GRID_HEIGHT / 2 < 0
				|| destination[0] + GridDrawer.GRID_HEIGHT / 2 > GridDrawer.GRID_HEIGHT) {
			destination[1] = GridDrawer.GRID_HEIGHT;
		}
		return destination;
	}
}

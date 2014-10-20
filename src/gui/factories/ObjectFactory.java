package gui.factories;

import gui.componentdrawers.TurtleScreenDrawer;

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
	public abstract Node[] generateObject(Map<String, String> params);

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
}

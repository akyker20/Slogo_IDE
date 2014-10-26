package commandParsing.colorCommandparsing;

import java.util.List;
import java.util.Queue;
import javafx.scene.paint.Color;
import workspaceState.WorkspaceState;
import commandParsing.drawableObectGenerationInterfaces.ColorIndexGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.FloatInputCommandParser;
import drawableobject.DrawableObject;

public class SetPalette extends FloatInputCommandParser implements ColorIndexGenerator {

	public SetPalette(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected int getNumberOfArguments() {
		return 4;
	}

	@Override
	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		double index = components.get(0);
		double r = components.get(1)/256;
		double g = components.get(2)/256;
		double b = components.get(3)/256;
		
		workspace.colorPalette.addToPalette((int) index, Color.color(r,g,b));
		objectQueue.add(generateDrawableObjectRepresentingColorIndex((int) index, Color.color(r,g,b)));
		return index;
	}

}

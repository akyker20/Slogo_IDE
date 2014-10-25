package commandParsing.colorCommandparsing;

import java.util.List;
import java.util.Queue;

import workspaceState.WorkspaceState;

import commandParsing.drawableObectGenerationInterfaces.PaneGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;

public class SetBackground extends OneInputFloatCommandParser implements PaneGenerator {

	public SetBackground(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		double index = components.get(0);
		objectQueue.add(generateDrawableObjectRepresentingPane(workspace.colorPalette.getFromPalette((int) index)));
		return index;
	}

}

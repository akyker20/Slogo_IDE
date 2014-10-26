package commandParsing.colorCommandparsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.Shape;
import workspaceState.WorkspaceState;

import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.ShapePaletteUpdateGenerator;
import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;

public class SetShapePalette extends CommandParser implements ShapePaletteUpdateGenerator {

	public SetShapePalette(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		accumulateComponents(commandStringIterator, 1, objectQueue);
		int index = (int) (double) expressionComponents.get(0);
		String path = commandStringIterator.next();
		Shape newShape = new Shape(path);
		workspace.shapePalette.addToPalette(index, newShape);
		objectQueue.add(generateDrawableObjectRepresentingShapePaletteUpdate(index, newShape));
		return index;
	}


}

package commandParsing;

import java.util.Iterator;
import java.util.Queue;

import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;
import workspaceState.WorkspaceState;

public class SetLanguage extends CommandParser {

	public SetLanguage(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		String language = commandStringIterator.next().substring(1);
		workspace.translator.createMappingsGivenLanguage(language);
		
		return 1;
	}

}

package commandParsing.drawableObectGenerationInterfaces;

import gui.commandlist.WorkspaceCommand;
import gui.factories.WorkspaceCommandFactory;


import java.util.HashMap;
import java.util.Map;

import drawableobject.DrawableObject;

public interface UserDefinedCommandGenerator {

	default public DrawableObject generateDrawableObjectRepresentingCommand(WorkspaceCommand command) {
		String parent = WorkspaceCommandFactory.PARENT;
		String type = WorkspaceCommandFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("name", command.getMyName());
		parameters.put("value", "" + command.getMyValue());

		return new DrawableObject(parent, type, parameters);
	}

}

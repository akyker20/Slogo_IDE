package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.UserDefinedCommandFactory;
import java.util.HashMap;
import java.util.Map;
import drawableobject.DrawableObject;

public interface UserDefinedCommandGenerator {

	default public DrawableObject generateDrawableObjectRepresentingCommand(String command) {
		String parent = UserDefinedCommandFactory.PARENT;
		String type = UserDefinedCommandFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("command", command);

		return new DrawableObject(parent, type, parameters);
	}

}

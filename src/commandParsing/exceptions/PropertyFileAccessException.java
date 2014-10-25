package commandParsing.exceptions;

import gui.factories.ErrorFactory;

import java.util.HashMap;
import java.util.Map;

import drawableobject.DrawableObject;

public class PropertyFileAccessException extends SLOGOException {

	private static final long serialVersionUID = 1L;

	public PropertyFileAccessException() {
		super();
	}

	public PropertyFileAccessException(String stringOfInterest) {
		super(stringOfInterest);
	}

	public PropertyFileAccessException(Throwable exception) {
		super(exception);
	}

	public PropertyFileAccessException(String stringOfInterest, Throwable cause) {
		super(stringOfInterest, cause);
	}

	public DrawableObject generateErrorMessage() {

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(ErrorFactory.ERROR_MESSAGE, "Error: I/O Exception");

		return new DrawableObject(ErrorFactory.PARENT, ErrorFactory.TYPE, parameters);
	}
	
}

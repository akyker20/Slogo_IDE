package commandParsing.exceptions;

import gui.factories.ErrorFactory;

import java.util.HashMap;
import java.util.Map;

import drawableobject.DrawableObject;

public class LanguageFileNotFoundException extends SLOGOException {

	private static final long serialVersionUID = 1L;

	public LanguageFileNotFoundException() {
		super();
	}

	public LanguageFileNotFoundException(String stringOfInterest) {
		super(stringOfInterest);
	}

	public LanguageFileNotFoundException(Throwable exception) {
		super(exception);
	}
	public LanguageFileNotFoundException(String stringOfInterest, Throwable cause) {
		super(stringOfInterest, cause);
	}

	public DrawableObject generateErrorMessage() {

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(ErrorFactory.ERROR_MESSAGE, "Error: file not found.");

		return new DrawableObject(ErrorFactory.PARENT, ErrorFactory.TYPE, parameters);
	}

}

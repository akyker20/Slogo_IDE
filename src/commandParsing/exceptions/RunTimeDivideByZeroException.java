package commandParsing.exceptions;

import gui.factories.ErrorFactory;
import java.util.HashMap;
import java.util.Map;
import drawableobject.DrawableObject;

public class RunTimeDivideByZeroException extends SLOGOException {

	private static final long serialVersionUID = 1L;

	public RunTimeDivideByZeroException() {
		super();
	}

	public RunTimeDivideByZeroException(String stringOfInterest) {
		super(stringOfInterest);
	}

	public RunTimeDivideByZeroException(Throwable exception) {
		super(exception);
	}

	public RunTimeDivideByZeroException(String stringOfInterest, Throwable cause) {
		super(stringOfInterest, cause);
	}

	@Override
	public DrawableObject generateErrorMessage() {

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(ErrorFactory.ERROR_MESSAGE, "Error: divided by zero.");

		return new DrawableObject(ErrorFactory.PARENT, ErrorFactory.TYPE, parameters);
	}

}

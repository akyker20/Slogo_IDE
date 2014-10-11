package commandParsing.exceptions;

import gui.factories.ErrorPopupFactory;
import java.util.HashMap;
import java.util.Map;
import drawableobject.DrawableObject;

public class RunTimeNullPointerException extends SLOGOException {

	private static final long serialVersionUID = 1L;

	public RunTimeNullPointerException (String stringOfInterest){
		super(stringOfInterest);
	}
	
	public RunTimeNullPointerException (Throwable exception){
		super(exception);
	}
	
	public RunTimeNullPointerException (String stringOfInterest, Throwable cause){
		super(stringOfInterest, cause);
	}

	@Override
	public DrawableObject generateErrorMessage() {
		
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put(ErrorPopupFactory.ERROR_MESSAGE,"Error: no such variable exists: " + this.getMessage() + ".");
		
		return new DrawableObject(ErrorPopupFactory.PARENT,ErrorPopupFactory.TYPE, parameters);
	}

}

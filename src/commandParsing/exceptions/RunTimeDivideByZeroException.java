package commandParsing.exceptions;

import java.util.HashMap;
import java.util.Map;

import drawableobject.DrawableObject;

public class RunTimeDivideByZeroException extends SLOGOException {
	
	public RunTimeDivideByZeroException(){
		super();
	}

	public RunTimeDivideByZeroException(String stringOfInterest) {
		super(stringOfInterest);
	}
	
	public RunTimeDivideByZeroException (Throwable exception){
		super(exception);
	}
	
	public RunTimeDivideByZeroException (String stringOfInterest, Throwable cause){
		super(stringOfInterest, cause);
	}

	@Override
	public DrawableObject generateErrorMessage() {
		
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("message","Error: divided by zero.");
		
		return new DrawableObject("parent", "ErrorMessage", parameters);
	}

}

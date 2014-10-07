package commandParsing.exceptions;

import java.util.HashMap;
import java.util.Map;

import drawableobject.DrawableObject;

public class CompileTimeParsingException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CompileTimeParsingException (String stringOfInterest){
		super(stringOfInterest);
	}
	
	public CompileTimeParsingException (Throwable exception){
		super(exception);
	}
	
	public CompileTimeParsingException (String stringOfInterest, Throwable cause){
		super(stringOfInterest, cause);
	}
	
	public DrawableObject generateErrorMessage(){
		
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("message",this.getMessage());
		
		return new DrawableObject("parent", "type", parameters);
	}
	
}

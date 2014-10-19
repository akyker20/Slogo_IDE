package commandParsing.exceptions;

import gui.factories.ErrorFactory;
import gui.factories.FactoryInitializer;
import java.util.HashMap;
import java.util.Map;
import drawableobject.DrawableObject;

public class CompileTimeParsingException extends SLOGOException {
	
	private static final long serialVersionUID = 1L;
	
	public CompileTimeParsingException (){
		super();
	}

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
		parameters.put(ErrorFactory.ERROR_MESSAGE,"Error parsing following string: " + this.getMessage()+ ". Incorrect syntax.");
		
		return new DrawableObject(ErrorFactory.PARENT,ErrorFactory.TYPE, parameters);
	}
	
}

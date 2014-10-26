package commandParsing.exceptions;

import drawableobject.DrawableObject;

/**
 * This is the general SLogoException that is used to catch almost any exception.
 * 
 * @author Stanley Yuan, Steve Kuznetsov
 *
 */

public abstract class SLOGOException extends Exception {
    private static final long serialVersionUID = 1L;

    public SLOGOException (String stringOfInterest) {
        super(stringOfInterest);
    }

    public SLOGOException (Throwable exception) {
        super(exception);
    }

    public SLOGOException (String stringOfInterest, Throwable cause) {
        super(stringOfInterest, cause);
    }

    public SLOGOException () {
        super();
    }

    public abstract DrawableObject generateErrorMessage ();

}

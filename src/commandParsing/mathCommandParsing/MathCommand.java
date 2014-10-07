package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.FloatInputCommandParser;
import commandParsing.exceptions.RunTimeDivideByZeroException;

import drawableobject.DrawableObject;



/**
 * Class parses String math commands into MathCommand objects
 *
 * @author steve, stanley
 *
 */
public abstract class MathCommand extends FloatInputCommandParser {
	
	@Override
	protected int getNumberOfArguments(){
		return 2;
	}
}

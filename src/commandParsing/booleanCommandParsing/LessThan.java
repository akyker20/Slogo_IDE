package commandParsing.booleanCommandParsing;

import commandParsing.exceptions.RunTimeDivideByZeroException;

public class LessThan extends BooleanCommand {

	@Override
	protected float returnFloat(String a, String b)	throws RunTimeDivideByZeroException {
		return Float.parseFloat(a) < Float.parseFloat(b) ? 1 : 0;
	}

	@Override
	protected String returnString(String a, String b) {
		return "LessThan" + " " + a + " " + b;
	}

}

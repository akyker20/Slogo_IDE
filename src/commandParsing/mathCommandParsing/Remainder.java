package commandParsing.mathCommandParsing;

import commandParsing.exceptions.RunTimeDivideByZeroException;


public class Remainder extends MathCommand {

	@Override
	protected float returnFloat(String a, String b) throws RunTimeDivideByZeroException {
		if(Float.parseFloat(a)==0 | Float.parseFloat(b)==0){
			throw new RunTimeDivideByZeroException();
		}
		return Float.parseFloat(a) % Float.parseFloat(b);
	}

	@Override
	protected String returnString(String a, String b) {
		return "Remainder" + " " + a + " " + b;
	}

}

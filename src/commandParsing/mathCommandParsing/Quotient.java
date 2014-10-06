package commandParsing.mathCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import stateUpdate.StateUpdate;


public class Quotient extends MathCommand {

	@Override
	protected float returnFloat(String a, String b) {
		return (float) Math.floor(Float.parseFloat(a) / Float.parseFloat(b));
	}

	@Override
	protected String returnString(String a, String b) {
		return "Quotient" + " " + a + " " + b;
	}

}

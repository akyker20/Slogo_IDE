package commandParsing.mathCommandParsing;


public class Product extends MathCommand {

	@Override
	protected float returnFloat(String a, String b) {
		return Float.parseFloat(a) * Float.parseFloat(b);
	}

	@Override
	protected String returnString(String a, String b) {
		return "Product" + " " + a + " " + b;
	}

}

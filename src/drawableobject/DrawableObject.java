package drawableobject;
import java.util.Map;


public class DrawableObject {
	
	private String parent;
	private String type;
	private String name;
	private Map<String,String> parameters;

	public DrawableObject(String someParent, String someType, String someName, Map<String, String> rawParameters) {
		parent = someParent;
		type = someType;
		name = someName;
		parameters = rawParameters;
	}

	public String getParent() {
		return parent;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

}

package workspaceState;

public class Shape {
	private String URI;
	
	public Shape(String path){
		URI = path;
	}
	
	public String getPath(){
		return URI;
	}
}
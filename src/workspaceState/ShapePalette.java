package workspaceState;

public class ShapePalette extends Palette<Shape> {
	
	public void addImageToPalette(int ID, String URI) {
		Shape shape = new Shape(URI);
		addToPalette(ID, shape);
	}
	
	public String getImageURIFromPalette(int ID){
		return getFromPalette(ID).getURI();
	}
	
}

package workspaceState;

public class ShapePalette extends Palette<String> {
	
	public void addImageToPalette(int ID, String URI) {
		addToPalette(ID, URI);
	}
	
	public String getImageURIFromPalette(int ID){
		return getFromPalette(ID);
	}
	
}

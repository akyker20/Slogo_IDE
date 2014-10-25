package workspaceState;

import java.util.HashMap;
import java.util.Map;

public class Palette<T> {
	private Map<Integer,T> palette = new HashMap<Integer,T>();
	
	public void addToPalette(int ID, T item){
		palette.put(ID, item);
	}
	
	public T getFromPalette(int ID){
		return palette.get(ID);
	}
}

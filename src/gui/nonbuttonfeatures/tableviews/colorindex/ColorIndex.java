package gui.nonbuttonfeatures.tableviews.colorindex;

import javafx.scene.paint.Color;

public class ColorIndex {
    private int myIndex;
    private Color myColor;
    
    public ColorIndex(int index, Color color){
        myIndex = index;
        myColor = color;
    }
    
    public int getMyIndex () {
        return myIndex;
    }

    public void setMyIndex (int myIndex) {
        this.myIndex = myIndex;
    }

    public Color getMyColor () {
        return myColor;
    }
    public void setMyColor (Color myColor) {
        this.myColor = myColor;
    }
}

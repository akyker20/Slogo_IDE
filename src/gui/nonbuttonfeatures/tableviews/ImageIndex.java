package gui.nonbuttonfeatures.tableviews;

import java.io.File;

public class ImageIndex {
    private int myIndex;
    private File myImageFile;
    
    public ImageIndex(int index, File image){
        myIndex = index;
        myImageFile = image;
    }

    public int getMyIndex () {
        return myIndex;
    }

    public void setMyIndex (int myIndex) {
        this.myIndex = myIndex;
    }

    public File getMyImageFile () {
        return myImageFile;
    }

    public void setMyImageFile (File myImageFile) {
        this.myImageFile = myImageFile;
    }
    
}

package gui.componentdrawers.optionsholder.tabs;

import gui.mainclasses.TextGenerator;
import gui.nonbuttonfeatures.tableviews.colorindex.ColorIndexFeature;
import gui.nonbuttonfeatures.tableviews.imageindex.ImageIndexFeature;

/**
 * The purpose of this class is to display the images and their indices to the user.
 * The user can then use these images (referenced by their index) to set the image
 * of the turtle.
 * @author akyker20
 *
 */
public class ImageIndexTab extends OptionsTab {

    public ImageIndexTab (ImageIndexFeature feature) {
        super(feature, TextGenerator.get(TextGenerator.IMAGES));
    }
    
}

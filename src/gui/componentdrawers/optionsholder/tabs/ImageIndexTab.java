package gui.componentdrawers.optionsholder.tabs;

import gui.mainclasses.TextGenerator;
import gui.nonbuttonfeatures.tableviews.colorindex.ColorIndexFeature;
import gui.nonbuttonfeatures.tableviews.imageindex.ImageIndexFeature;

public class ImageIndexTab extends OptionsTab {

    public ImageIndexTab (ImageIndexFeature feature) {
        super(feature, TextGenerator.get(TextGenerator.IMAGES));
    }
    
}

package gui.componentdrawers.optionsholder.tabs;

import gui.mainclasses.TextGenerator;
import gui.nonbuttonfeatures.tableviews.colorindex.ColorIndexFeature;

public class ColorIndexTab extends OptionsTab {

    public ColorIndexTab (ColorIndexFeature feature) {
        super(feature, TextGenerator.get(TextGenerator.COLORS));
        
    }
    
}

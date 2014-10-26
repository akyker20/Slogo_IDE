package gui.componentdrawers.optionsholder.tabs;

import gui.mainclasses.TextGenerator;
import gui.nonbuttonfeatures.tableviews.colorindex.ColorIndexFeature;

/**
 * This tab will allow the user to see the available color palette. This
 * palette will contain all of the colors the user can use. The user can
 * use these colors by referencing their index.
 * @author akyker20
 *
 */
public class ColorIndexTab extends OptionsTab {

    public ColorIndexTab (ColorIndexFeature feature) {
        super(feature, TextGenerator.get(TextGenerator.COLORS));
        
    }
    
}

package gui.componentdrawers.significantcommands.tabs;

import gui.mainclasses.TextGenerator;
import gui.nonbuttonfeatures.SavedCommandsFeature;
import java.util.List;
import javafx.scene.control.Tab;


/**
 * This tab allows the user to see saved commands. The user can double click on
 * these commands and they will appear in the command line without the user
 * having to type them again.
 *
 * @author akyker20
 *
 */
public class SavedCommandsTab extends Tab {

    private SavedCommandsFeature myFeature;

    public SavedCommandsTab (SavedCommandsFeature feature) {
        setText(TextGenerator.get(TextGenerator.SAVED));
        setClosable(false);
        myFeature = feature;
        setContent(feature);
    }

    public void loadCommands (List<String> savedCommands) {
        myFeature.loadCommands(savedCommands);
    }

    public List<String> getCommands () {
        return myFeature.getCommands();
    }

}

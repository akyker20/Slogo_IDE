package gui.componentdrawers.significantcommands.tabs;

import gui.nonbuttonfeatures.SavedCommandsFeature;
import java.util.List;
import javafx.scene.control.Tab;

public class SavedCommandsTab extends Tab {
    
    private static final String SAVED = "Saved";
    private SavedCommandsFeature myFeature;

    public SavedCommandsTab (SavedCommandsFeature feature) {
        this.setText(SAVED);
        this.setClosable(false);
        myFeature = feature;
        this.setContent(feature);
    }

    public void loadCommands (List<String> savedCommands) {
        myFeature.loadCommands(savedCommands); 
    }
    
    public List<String> getCommands(){
        return myFeature.getCommands();
    }

}

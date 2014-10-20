package gui.componentdrawers;

import gui.nonbuttonfeatures.SavedCommandsFeature;
import java.util.List;
import javafx.scene.control.Label;

public class SavedCommandsDrawer extends ComponentDrawer {
    
    private SavedCommandsFeature myFeature;

    public SavedCommandsDrawer (String name) {
        super(name);
        this.drawShape(new Label[]{new Label("Saved Commands")});
    }
    
    public void setFeature(SavedCommandsFeature feature){
        myFeature = feature;
    }

    public void loadCommands (List<String> savedCommands) {
        myFeature.loadCommands(savedCommands);
        
    }
    
    public List<String> getCommands(){
        return myFeature.getCommands();
    }

}

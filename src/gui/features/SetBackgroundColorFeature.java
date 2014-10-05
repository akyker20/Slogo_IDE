package gui.features;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.GridDrawer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;

public class SetBackgroundColorFeature extends ColorPicker implements Feature {
    
    public SetBackgroundColorFeature(GridDrawer targetDrawer, ButtonHolderDrawer parentDrawer){
        this.setOnAction(event->changeColor(targetDrawer));
        parentDrawer.drawShape(this);
    }

    private void changeColor(GridDrawer targetDrawer) {
        targetDrawer.setStyle("-fx-background-color: " + getPickerColor());
    }
    
    private String getPickerColor() {
        return "#" + SetBackgroundColorFeature.this.getValue().toString().substring(2);
    } 
    
    @Override
    public void act () {
        
        
    }

}

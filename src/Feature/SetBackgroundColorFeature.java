package Feature;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import GUI.ButtonHolderDrawer;
import GUI.GridDrawer;

public class SetBackgroundColorFeature extends ColorPicker implements Feature {
    
    public SetBackgroundColorFeature(GridDrawer targetDrawer, ButtonHolderDrawer parentDrawer){
        this.setOnAction(new EventHandler() {
            public void handle(Event t) {
                targetDrawer.setStyle("-fx-background-color: " + getPickerColor());
            }

            private String getPickerColor() {
                return "#" + SetBackgroundColorFeature.this.getValue().toString().substring(2);
            }
        });
        parentDrawer.drawShape(this);
    }

    @Override
    public void act () {
        
        
    }

}

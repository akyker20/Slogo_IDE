package Feature;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import GUI.ButtonHolderDrawer;
import GUI.GridDrawer;

public class SetBackgroundColorFeature implements Feature {
    
    public SetBackgroundColorFeature(GridDrawer targetDrawer, ButtonHolderDrawer parentDrawer){
        ColorPicker picker = new ColorPicker();
        picker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                targetDrawer.setStyle("-fx-background-color: " + getPickerColor(picker));
            }

            private String getPickerColor(ColorPicker picker) {
                return "#" + picker.getValue().toString().substring(2);
            }
        });
        parentDrawer.drawShape(picker);
    }

    @Override
    public void act () {
        
        
    }

}

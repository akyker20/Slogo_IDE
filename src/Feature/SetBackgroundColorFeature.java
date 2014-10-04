package Feature;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import GUI.ButtonHolderDrawer;
import GUI.GridDrawer;

public class SetBackgroundColorFeature implements Feature {
    
    private ButtonHolderDrawer myParentDrawer;

    public SetBackgroundColorFeature(GridDrawer targetDrawer, ButtonHolderDrawer parentDrawer){
        myParentDrawer = parentDrawer;
        ColorPicker picker = new ColorPicker();
        picker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                targetDrawer.setStyle("-fx-background-color: " + getPickerColor(picker));
            }

            private String getPickerColor(ColorPicker picker) {
                return "#" + picker.getValue().toString().substring(2);
            }
        });
        myParentDrawer.drawShape(picker);
    }

    @Override
    public void act () {
        
        
    }

}

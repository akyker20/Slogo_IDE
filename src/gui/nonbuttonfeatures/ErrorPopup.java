package gui.nonbuttonfeatures;

import gui.mainclasses.StageInitializer;
import javafx.scene.control.Label;
import javafx.stage.Popup;

public class ErrorPopup extends Popup {
    public static final double ERROR_POPUP_WIDTH = StageInitializer.SCREEN_WIDTH/3;
    public static final double ERROR_POPUP_HEIGHT = StageInitializer.SCREEN_HEIGHT/3;
    
    public ErrorPopup(String errorMessage) {
        this.setWidth(ERROR_POPUP_WIDTH);
        this.setHeight(ERROR_POPUP_HEIGHT);
        this.setX(StageInitializer.SCREEN_WIDTH/2 - ERROR_POPUP_WIDTH/2);
        this.setY(StageInitializer.SCREEN_HEIGHT/2- ERROR_POPUP_HEIGHT/2);
        
        Label message = new Label(errorMessage);
        message.getStylesheets().add("/Stylesheets/style.css");
        message.getStyleClass().add("errorPopup");
        this.getContent().add(message);
    }
}

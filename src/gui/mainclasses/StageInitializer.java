package gui.mainclasses;

import gui.componentdrawers.SavedCommandsDrawer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.menus.MainMenuInitializer;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Control.SlogoGraphics;


public class StageInitializer {

    public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 700;
    public static final String STYLESHEET_PACKAGE = "Stylesheets/";

    public static BorderPane init (Stage stage, SlogoGraphics control) {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        Scene scene = new Scene(pane, SCREEN_WIDTH, SCREEN_HEIGHT, Color.CORNSILK);
        scene.getStylesheets().add(STYLESHEET_PACKAGE + "style.css");
        stage.setScene(scene);
        stage.setTitle("SLogo");
        stage.setResizable(false);
        stage.show();
        return pane;
    }
}
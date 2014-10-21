package gui.mainclasses;

import java.io.IOException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import gui.factories.TurtleFactory;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
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
        pane.setOnKeyReleased(event->ifActiveMoveTurtle(event, control));
        Scene scene = new Scene(pane, SCREEN_WIDTH, SCREEN_HEIGHT, Color.CORNSILK);
        scene.getStylesheets().add(STYLESHEET_PACKAGE + "style.css");
        stage.setScene(scene);
        stage.setTitle("SLogo");
        stage.setResizable(false);
        stage.show();
        return pane;
    }

    private static void ifActiveMoveTurtle (KeyEvent event, SlogoGraphics control) {
        if(TurtleFactory.isTurtleSelected()){
            String command = null;
            switch(event.getCode()){
                case UP: command = "fd 10"; break;
                case DOWN: command = "bk 10"; break;
                case RIGHT: command = "right 90"; break;
                case LEFT: command = "left 90"; break;
                default:
                    break;
            }
            try {
                control.parseCommandString(command);
            }
            catch (CompileTimeParsingException | RunTimeDivideByZeroException
                    | RunTimeNullPointerException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
package gui.nonbuttonfeatures;
import java.io.IOException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import Control.SlogoControl;
import Control.SlogoGraphics;
import gui.componentdrawers.CommandLineDrawer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.TurtleFactory;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
/**
 * This is the grid. The reason it is a feature is that we may make
 * it interactive in the future - for instance click to draw another
 * turtle
 * @author Austin Kyker
 *
 */
public class TurtleScreenFeature extends Pane {
    public TurtleScreenFeature(TurtleScreenDrawer parentDrawer){
        this.setPrefWidth(TurtleScreenDrawer.GRID_WIDTH);
        this.setPrefHeight(TurtleScreenDrawer.GRID_HEIGHT);
        this.getStyleClass().add("grid");
        this.setLayoutY(20);
        parentDrawer.setTurtleScreenFeature(this);
       
    }
}
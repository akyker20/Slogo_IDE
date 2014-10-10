package gui.nonbuttonfeatures;

import java.io.IOException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import gui.componentdrawers.CommandLineDrawer;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import Control.SlogoGraphics;


public class CommandLineFeature extends TextField {

    public CommandLineFeature (CommandLineDrawer parentDrawer, ObservableList<String> list, SlogoGraphics control) {
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent e) {
                if (e.getCode().equals(KeyCode.ENTER)) {
                    try {
                        String command = CommandLineFeature.this.getText();
                        control.parseCommandString(command);
                        list.add(command);
                    }
                    catch (CompileTimeParsingException | RunTimeDivideByZeroException
                            | RunTimeNullPointerException | IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    CommandLineFeature.this.clear();
                }
            }
        });
        this.setPrefWidth(parentDrawer.getWidth());
        this.setLayoutY(20);
        parentDrawer.setCommandLine(this);
        parentDrawer.drawShape(this);
        this.requestFocus();
    }

}

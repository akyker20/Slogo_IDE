package gui.features;

import java.io.IOException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import gui.componentdrawers.CommandLineDrawer;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import Control.SlogoGraphics;


public class CommandLineFeature extends TextField {

    public CommandLineFeature (CommandLineDrawer parentDrawer, SlogoGraphics control) {
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent e) {
                if (e.getCode().equals(KeyCode.ENTER)) {
                    try {
                        control.parseCommandString(CommandLineFeature.this.getText());
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
        parentDrawer.drawShape(this);
    }

}

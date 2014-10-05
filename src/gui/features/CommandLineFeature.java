package gui.features;

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
                    control.parseCommandString(CommandLineFeature.this.getText());
                    CommandLineFeature.this.clear();
                }
            }
        });

        parentDrawer.drawShape(this);
    }

}

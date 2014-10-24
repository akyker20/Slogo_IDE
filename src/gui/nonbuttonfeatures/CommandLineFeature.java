package gui.nonbuttonfeatures;

import gui.componentdrawers.CommandLineDrawer;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import Control.SlogoGraphics;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;


public class CommandLineFeature extends TextArea {

    public CommandLineFeature (CommandLineDrawer parentDrawer, SlogoGraphics control) {

        KeyCombination newLineCombination = new KeyCodeCombination(KeyCode.ENTER,KeyCombination.SHIFT_DOWN);

        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent e) {
                if(newLineCombination.match(e)){
                    CommandLineFeature.this.setText(CommandLineFeature.this.getText()+"\n");
                    CommandLineFeature.this.positionCaret(CommandLineFeature.this.getLength());
                }
                else if (e.getCode().equals(KeyCode.ENTER)) {
                    try {
                        String uncleanCommand = CommandLineFeature.this.getText();
                        String cleanedCommand = cleanCommand(uncleanCommand);
                        if(!cleanedCommand.isEmpty()){
                            control.parseCommandString(cleanedCommand);
                        }
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
        this.setPrefRowCount(4);
        this.setLayoutY(20);
        parentDrawer.setCommandLine(this);
        parentDrawer.drawShape(new CommandLineFeature[]{this});
        this.requestFocus();
    }

    protected String cleanCommand (String text) {
        return text.replace("\n", " ").trim();
    }

}

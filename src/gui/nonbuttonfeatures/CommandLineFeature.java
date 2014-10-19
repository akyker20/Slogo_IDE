package gui.nonbuttonfeatures;

import java.io.IOException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import gui.componentdrawers.CommandLineDrawer;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import Control.SlogoGraphics;


public class CommandLineFeature extends TextArea {

    public CommandLineFeature (CommandLineDrawer parentDrawer, ObservableList<String> list, SlogoGraphics control) {

        KeyCombination newLineCombination = new KeyCodeCombination(KeyCode.ENTER,KeyCombination.SHIFT_DOWN);

        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent e) {
                if(newLineCombination.match(e)){
                    System.out.println("HERE");
                    CommandLineFeature.this.setText(CommandLineFeature.this.getText()+"\n");
                    CommandLineFeature.this.positionCaret(CommandLineFeature.this.getLength());
                }
                else if (e.getCode().equals(KeyCode.ENTER)) {
                    try {
                        String uncleanCommand = CommandLineFeature.this.getText();
                        String cleanedCommand = cleanCommand(uncleanCommand);
                        if(!cleanedCommand.isEmpty()){
                            control.parseCommandString(cleanedCommand);
                            list.add(uncleanCommand);
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
        parentDrawer.drawShape(this);
        this.requestFocus();
    }

    protected String cleanCommand (String text) {
        return text.replace("\n", "");
    }

}

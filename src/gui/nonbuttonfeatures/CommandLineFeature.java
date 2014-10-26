package gui.nonbuttonfeatures;

import gui.componentdrawers.CommandLineDrawer;
import gui.mainclasses.workspace.Workspace;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

/**
 * Class manages command entering through the command line
 * @author akyker20, allankiplagat
 *
 */
public class CommandLineFeature extends TextArea {

    public CommandLineFeature (CommandLineDrawer parentDrawer, Workspace workspace) {

        KeyCombination newLineCombination =
                new KeyCodeCombination(KeyCode.ENTER, KeyCombination.SHIFT_DOWN);

        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent e) {
                if (newLineCombination.match(e)) {
                    CommandLineFeature.this.setText(CommandLineFeature.this.getText() + "\n");
                    CommandLineFeature.this.positionCaret(CommandLineFeature.this.getLength());
                }
                else if (e.getCode().equals(KeyCode.ENTER)) {
                    String uncleanCommand = CommandLineFeature.this.getText();
                    String cleanedCommand = cleanCommand(uncleanCommand);
                    if (!cleanedCommand.isEmpty()) {
                        workspace.parseCommandString(cleanedCommand);
                    }
                    CommandLineFeature.this.clear();
                }
            }
        });
        setPrefWidth(parentDrawer.getWidth());
        setPrefRowCount(1);
        setLayoutY(20);
        parentDrawer.setCommandLine(this);
        parentDrawer.drawShape(new CommandLineFeature[] { this });
        requestFocus();
    }

    protected String cleanCommand (String text) {
        return text.replace("\n", " ").trim();
    }

}

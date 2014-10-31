package gui.componentdrawers;

import gui.mainclasses.StageInitializer;
import gui.mainclasses.TextGenerator;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


/**
 * The command line drawer is the component responsible for the command line feature.
 *
 * @author akyker20
 *
 */
public class CommandLineDrawer extends ComponentDrawer {

    private TextArea myCommandLine;

    public CommandLineDrawer (String name) {
        super(name);
        getStyleClass().add("commandLine");
        setWidth(StageInitializer.SCREEN_WIDTH * TurtleScreenDrawer.GRID_WIDTH_RATIO);
        drawShape(new Label[] { new Label(textGen.get(TextGenerator.COMMAND_LINE)) });
    }

    /**
     * Provides this drawer with access to the command line text field so that certain
     * features can get access to the current text value of the field.
     *
     * @param t
     */
    public void setCommandLine (TextArea t) {
        myCommandLine = t;
    }

    /**
     * Returns the current text in the command line, called from the SaveCommandButtonFeature.
     * That feature needs the current input value so it can pass it to the back-end to be saved.
     *
     * @return
     */
    public String getCurrentCommand () {
        return myCommandLine.getText();
    }

    /**
     * Sets the text of the command line text field to be the input string.
     * This is called when a previous command is clicked (PreviousCommandFeature)
     *
     * @param s
     */
    public void setCommandLine (String s) {
        myCommandLine.setText(s);
    }

}

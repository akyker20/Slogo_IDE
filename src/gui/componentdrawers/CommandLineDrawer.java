package gui.componentdrawers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import gui.mainclasses.StageInitializer;


public class CommandLineDrawer extends ComponentDrawer {
    
    private TextField myCommandLine;

    public CommandLineDrawer (String name) {
        super(name);
        getStyleClass().add("commandLine");
        setWidth(StageInitializer.SCREEN_WIDTH * TurtleScreenDrawer.GRID_WIDTH_RATIO);
        this.drawShape(new Label("Command Line"));
    }
    
    /**
     * Provides this drawer with access to the command line text field so that certain
     * features can get access to the current text value of the field.
     * @param t
     */
    public void setCommandLine(TextField t){
        myCommandLine = t;
    }

    /**
     * Returns the current text in the command line, called from the SaveCommandButtonFeature.
     * That feature needs the current input value so it can pass it to the backend to be saved.
     * @return
     */
    public String getCurrentCommand () {
        return myCommandLine.getText();
    }
    
    
    /**
     * Sets the text of the command line text field to be the input string.
     * This is called when a previous command is clicked (PreviousCommandFeature)
     * @param s
     */
    public void setCommandLine(String s){
        myCommandLine.setText(s);
    }

}

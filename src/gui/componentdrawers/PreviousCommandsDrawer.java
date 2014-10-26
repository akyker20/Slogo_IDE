package gui.componentdrawers;

import gui.mainclasses.StageInitializer;
import gui.mainclasses.TextGenerator;
import javafx.scene.control.Label;

/**
 * Class manages displaying of previous commands
 * @author akyker20, allankiplagat
 *
 */
public class PreviousCommandsDrawer extends ComponentDrawer {

    public PreviousCommandsDrawer (String name) {
        super(name);
        getStyleClass().add("previousCommands");
        setWidth(StageInitializer.SCREEN_WIDTH * TurtleScreenDrawer.GRID_WIDTH_RATIO);
        drawShape(new Label[] { new Label(TextGenerator.get(TextGenerator.PREVIOUS_COMMANDS)) });
    }

}

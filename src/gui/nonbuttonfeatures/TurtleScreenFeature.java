package gui.nonbuttonfeatures;

import gui.componentdrawers.TurtleScreenDrawer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import XML.readers.SavedWorkspaceXMLReader;
import XML.workspaceparams.WorkspaceScreenParameters;


/**
 * This is the turtle screen. The reason it is a feature is that we may make
 * it interactive in the future - for instance click to draw another
 * turtle
 *
 * @author Austin Kyker
 *
 */
public class TurtleScreenFeature extends Pane {

    private static final String COLOR = SavedWorkspaceXMLReader.COLOR;
    private static final String TOGGLE_GRID = SavedWorkspaceXMLReader.TOGGLE_GRID;

    /**
     * Constructor
     * @param parentDrawer
     * @param screenParams - parameters used to set up the screen. Will be null
     * unless an xml file was loaded containing screen parameters.
     */
    public TurtleScreenFeature (TurtleScreenDrawer parentDrawer,
                                WorkspaceScreenParameters screenParams) {
        setPrefWidth(TurtleScreenDrawer.GRID_WIDTH);
        setPrefHeight(TurtleScreenDrawer.GRID_HEIGHT);
        getStyleClass().add("grid");
        setLayoutY(20);
        parentDrawer.setTurtleScreenFeature(this);

        if (screenParams.extractParams(TOGGLE_GRID).equalsIgnoreCase("true")) {
            parentDrawer.toggleGrid();
        }
        if (screenParams.hasParam(COLOR)) {
            parentDrawer.changeScreenColor(Color.valueOf(
                    screenParams.extractParams(COLOR)));
        }
    }
}

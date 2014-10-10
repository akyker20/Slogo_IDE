package gui.componentdrawers;

import gui.mainclasses.StageInitializer;


public class GridDrawer extends ComponentDrawer {

    public static final double GRID_WIDTH_RATIO = .667;
    public static final double GRID_HEIGHT_RATIO = .6;
    public static final double GRID_WIDTH = StageInitializer.SCREEN_WIDTH * GRID_WIDTH_RATIO;
    public static final double GRID_HEIGHT = StageInitializer.SCREEN_HEIGHT * GRID_HEIGHT_RATIO;

    public GridDrawer (String name) {
        super(name);
        getStyleClass().add("gridPane");
        this.setPrefWidth(GRID_WIDTH);
        this.setPrefHeight(GRID_HEIGHT);
    }
}

package GUI;

public class CommandLineDrawer extends ComponentDrawer {

    public CommandLineDrawer(String name) {
        super(name);
        this.getStyleClass().add("commandLine");
        this.setPrefWidth(GUIInitializer.SCREEN_WIDTH*GridDrawer.GRID_WIDTH_RATIO);
    }

}

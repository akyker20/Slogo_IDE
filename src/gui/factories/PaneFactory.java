package gui.factories;

import gui.componentdrawers.ComponentBuilder;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.turtlefactory.NullNode;
import gui.mainclasses.FactoryBuilder;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 * Class handles drawable objects to both reset the turtle screen and to
 * change the background color of the turtle screen.
 * @author akyker20, allankiplagat
 *
 */
public class PaneFactory extends ObjectFactory {

    public static final String PARENT = ComponentBuilder.SCREEN_DRAWER;
    public static final String TYPE = FactoryBuilder.CLEAR_GRID_FACTORY;
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String RESET_FLAG = "resetFlag";

    private TurtleScreenDrawer myTurtleScreen;

    public PaneFactory (String name, TurtleScreenDrawer drawer) {
        super(name);
        myTurtleScreen = drawer;
    }

    /**
     * If the reset flag parameter is true, the drawable object
     * is indicating that the turtle screen should be reset. Otherwise,
     * the background color of the screen is being modified.
     */
    @Override
    public Node[] generateObject (Map<String, String> params) {
        if (params.get(RESET_FLAG).equalsIgnoreCase("true")) {
            myTurtleScreen.resetScreen();
        }
        else {
            myTurtleScreen
            .changeScreenColor(Color.valueOf(params.get(BACKGROUND_COLOR)));
        }
        return new Node[] { new NullNode() };
    }

}

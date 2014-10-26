package gui.factories;

import gui.componentdrawers.ComponentBuilder;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.turtlefactory.NullNode;
import java.util.Map;
import javafx.scene.Node;

public class ScreenColorFactory extends ObjectFactory {

    public static final String PARENT = ComponentBuilder.SCREEN_DRAWER;
    public static final String TYPE = FactoryBuilder.SCREEN_COLOR_FACTORY;
    private static final Object COLOR = "Color";
    
    private TurtleScreenDrawer myTurtleScreenDrawer;

    public ScreenColorFactory (String name, TurtleScreenDrawer drawer) {
        super(name);
        myTurtleScreenDrawer = drawer;
    }

    @Override
    public Node[] generateObject (Map<String, String> params) {
        myTurtleScreenDrawer.changeScreenColor("-fx-background-color: " + params.get(COLOR));
        return new Node[]{new NullNode()};
    }

}

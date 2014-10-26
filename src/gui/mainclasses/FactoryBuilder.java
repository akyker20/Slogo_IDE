package gui.mainclasses;


import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.ColorPaletteEntryFactory;
import gui.factories.ErrorFactory;
import gui.factories.LineFactory;
import gui.factories.ObjectFactory;
import gui.factories.PaneFactory;
import gui.factories.ShapePaletteEntryFactory;
import gui.factories.WorkspaceVariableFactory;
import gui.factories.turtlefactory.TurtleFactory;
import gui.factories.turtlefactory.TurtleNodes;
import gui.factories.userdefinedcommands.UserDefinedCommandFactory;
import gui.mainclasses.workspace.WorkspaceDataHolder;

public class FactoryBuilder {

    public static final String LINE_FACTORY = "LineFactory";
    public static final String TURTLE_FACTORY = "TurtleFactory";
    public static final String ERROR_FACTORY = "ErrorFactory";
    public static final String CLEAR_GRID_FACTORY = "ClearGridFactory";
    public static final String WORKSPACE_VARIABLE_FACTORY = "WorkspaceVariableFactory";
    public static final String USER_DEFINED_COMMAND_FACTORY = "UserDefinedCommandFactory";
    public static final String SCREEN_COLOR_FACTORY = "ScreenColorFactory";
    public static final String COLOR_INDEX_FACTORY = "ColorIndexFactory";
    public static final String SHAPE_PALETTE_INDEX_FACTORY = "ShapePaletteEntryFactory";

    /**
     * Makes the object factories
     * @return an array of object factories
     */
    public static ObjectFactory[] init (WorkspaceDataHolder holder, TurtleScreenDrawer drawer,
                                        TurtleNodes turtleNodes) {
        return new ObjectFactory[] {
                                    new LineFactory(LINE_FACTORY),
                                    new TurtleFactory(TURTLE_FACTORY, turtleNodes),
                                    new ErrorFactory(ERROR_FACTORY),
                                    new PaneFactory(CLEAR_GRID_FACTORY, drawer),
                                    new WorkspaceVariableFactory(WORKSPACE_VARIABLE_FACTORY, holder.getMyVariablesList()),
                                    new UserDefinedCommandFactory(USER_DEFINED_COMMAND_FACTORY, holder.getMyUserDefinedCommandList()),
                                    new ColorPaletteEntryFactory(COLOR_INDEX_FACTORY, holder.getMyColorIndexList()),
                                    new ShapePaletteEntryFactory(SHAPE_PALETTE_INDEX_FACTORY, holder.getMyImageIndexList())
        };
    }

}

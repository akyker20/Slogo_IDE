package gui.factories;

import gui.componentdrawers.GridDrawer;

public class GridEdgeRules {

    public static double[] applyRules(double[] origin, double[] destination) {
        if ((destination[0] + GridDrawer.GRID_WIDTH / 2 < 0)
                ||(destination[0] + GridDrawer.GRID_WIDTH / 2 > GridDrawer.GRID_WIDTH)
                ||(destination[1] + GridDrawer.GRID_HEIGHT / 2 < 0)
                ||(destination[0] + GridDrawer.GRID_HEIGHT / 2 > GridDrawer.GRID_HEIGHT)) 
        {
            return computeNewDestination(origin,destination);
        } else {
            return destination;
        }
    }

    public static double[] computeNewDestination(double[] origin, double[] destination) {
        //code here
        return destination;
    }
}

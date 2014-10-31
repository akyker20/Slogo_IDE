package gui.factories.turtlefactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the TurtleNode and TurtleNodes classes
 * and their functions.
 * @author Austin Kyker
 *
 */
public class TurtleNodeTest {
    
    private static final int NUM_NODES = 3;
    
    private TurtleNodes myTurtleNodes;
    
    /**
     * Create a TurtleNodes object that can be tested below.
     */
    @Before
    public void setUp(){
        myTurtleNodes = new TurtleNodes(null);
        for(int i = 0; i < NUM_NODES; i++){
            Map<String, String> params = new HashMap<String, String>();
            params.put(TurtleFactory.TURTLE_ID, i + "");
            addDefaultParams(params);
            myTurtleNodes.addTurtleNode(params);
        }
    }

    private void addDefaultParams (Map<String, String> params) {
        params.put(TurtleFactory.LOCATION, "0 0");
        params.put(TurtleFactory.HEADING, "0");
        params.put(TurtleFactory.OPACITY, "1.0");         
    }

    /**
     * Ensure that a turtle is selected when it is created and that it's
     * ID is assigned correctly.
     */
    @Test
    public void turtleNodeCreationTest () {
        Map<String, String> params = new HashMap<String, String>();
        String turtleID = "01";
        params.put(TurtleFactory.TURTLE_ID, turtleID);
        addDefaultParams(params);
        TurtleNode turtleNode = new TurtleNode(params, null);
        assertEquals(true, turtleNode.isSelected());
        assertEquals(turtleID, turtleNode.getTurtleID());
    }
    
    /**
     * Test the turtle node lookup function that looks up a turtle node
     * by its id.
     */
    @Test
    public void turtleNodesLookupTest(){
        for(int i = 0; i < NUM_NODES; i++){
            assertNotNull(myTurtleNodes.getTurtleWithID(i+""));
        }
        assertNull(myTurtleNodes.getTurtleWithID((NUM_NODES+1)+""));
    }
    
    /**
     * All turtle nodes added to the TurtleNodes structure should be active.
     */
    @Test
    public void activeTurtlesNodeTest(){
        assertEquals(NUM_NODES, myTurtleNodes.getActiveNodes().size());
    }
    
    /**
     * Test to ensure that the static turtle node method of parsing a pair of
     * coordinate points from a String works correctly.
     */
    @Test
    public void parseStringToPointsTest(){
        int xLoc = 20;
        int yLoc = 30;
        String location = xLoc + " " + yLoc;
        double[] points = TurtleNode.parseStringToPoints(location);
        assertEquals(xLoc, new Double(points[0]).intValue());
        assertEquals(yLoc, new Double(points[1]).intValue());        
    }
    
    /**
     * Tests that the clear nodes method removes all of the turtle nodes
     * successfully.
     */
    @Test
    public void testClearTurtleNodes() {
        myTurtleNodes.clearTurtleNodes();
        assertEquals(0, myTurtleNodes.getActiveNodes().size());
    }
}
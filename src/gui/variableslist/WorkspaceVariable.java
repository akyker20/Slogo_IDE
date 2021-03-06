package gui.variableslist;

/**
 * Class is used to represent variables displayed on the GUI. This 
 * class is necessary to create a tableview of workspace variables.
 * @author akyker20, allankiplagat
 *
 */
public class WorkspaceVariable {

    private String myName;
    private double myValue;

    public WorkspaceVariable (String name, double value) {
        myName = name;
        myValue = value;
    }

    public String getMyName () {
        return myName;
    }

    public void setMyName (String myName) {
        this.myName = myName;
    }

    public double getMyValue () {
        return myValue;
    }

    /**
     * Necessary to make the value editable.
     * @param myValue
     */
    public void setMyValue (double myValue) {
        this.myValue = myValue;
    }

    public void addValue (double value) {
        myValue += value;
    }
}

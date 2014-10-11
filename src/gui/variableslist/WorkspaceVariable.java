package gui.variableslist;

public class WorkspaceVariable  {
    
    private String myName;
    private double myValue;
    
    public WorkspaceVariable(String name, double value){
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

    public void setMyValue (double myValue) {
        this.myValue = myValue;
    }    
}

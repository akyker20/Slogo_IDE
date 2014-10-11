package gui.variableslist;

public class WorkspaceVariable  {
    
    private String myName;
    private int myValue;
    
    public WorkspaceVariable(String name, int value){
        myName = name;
        myValue = value;
    }

    public String getMyName () {
        return myName;
    }

    public void setMyName (String myName) {
        this.myName = myName;
    }

    public int getMyValue () {
        return myValue;
    }

    public void setMyValue (int myValue) {
        this.myValue = myValue;
    }    
}

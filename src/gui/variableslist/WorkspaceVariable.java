package gui.variableslist;

import java.io.Serializable;

public class WorkspaceVariable  implements Serializable {
    
	private static final long serialVersionUID = -3083713008607735263L;
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
    
    public void addValue (double value){
    	myValue += value;
    }
}

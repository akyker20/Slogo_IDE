package interfaceBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Class is used by the GUIController class to generate a SLogoGraphicsInterface
 * defining the listener and action methods required to interact with components in the GUI
 *
 * @author allankiplagat
 *
 */
public class SLogoGraphicsInterfaceBuilder {
    // TODO: figure out more dynamic way of assigning package name
    private String packageName;
    private String className;
    private StringBuilder classText;

    protected SLogoGraphicsInterfaceBuilder () {
        className = "SLogoGraphicsInterface";
        // NOTE: for now, packageName must match current package
        packageName = "interfaceBuilder";
        classText = new StringBuilder();
        writeClassHeaders();
    }

    /**
     * Method writes the header code in the SLogoGraphicsInterface class
     */
    private void writeClassHeaders () {
        classText.append("package " + packageName + "; \n \n");
        classText.append("public interface " + className + " { \n");
    }

    /**
     * Method adds a listener method to the listener interface class
     * 
     * @param methodSignature The method name
     * @param methodArgument The argument that the method will receive
     * @return True if method was added to class successfully, False otherwise
     */

    protected boolean addListenerMethod (String methodSignature, String methodArgument) {
        // TODO: have method do checks on the methodSignature and methodArgument validity first
        classText.append("protected abstract void " + methodSignature + " (" + methodArgument +
                         "); \n");
        return true;
    }

    /**
     * Method writes out the constructed class into an actual java source code class file
     * 
     * @return True if class written to file successfully, false otherwise
     */
    protected boolean writeClass () {
        writeClassFooters();
        try {
            File file = new File("src/" + packageName + "/" + className + ".java");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(classText.toString());
            output.close();
            return true;
        }
        catch (IOException e) {
            System.out.println("Class write failed\n");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method writes closing code in the SLogoGraphicsInterface class
     */
    private void writeClassFooters () {
        classText.append("}\n");
    }
}

package interfaceBuilder;

public class SLogoGraphicsInterfaceBuilderTester {
    protected static void main (String[] args) {
        SLogoGraphicsInterfaceBuilder interfaceBuilder = new SLogoGraphicsInterfaceBuilder();
        String methodSignature = "doButtonAction", methodArgument = "";
        boolean addMethodResult = interfaceBuilder.addListenerMethod(methodSignature, methodArgument);
        System.out.println("Listener method added result: "+addMethodResult+"\n");
        boolean writeClassResult = interfaceBuilder.writeClass();
        System.out.println("Write-class result: "+writeClassResult+"\n");
    }
}

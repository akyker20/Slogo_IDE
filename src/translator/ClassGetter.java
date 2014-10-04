package translator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import commandParsing.turtleCommandParsing.Forward;

public class ClassGetter {
	private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes.toArray(new Class[classes.size()]);
	}

	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
	}
	
	private static Set<Class> getClassesInPackage(String packageName) {  
	    Set<Class> classes = new HashSet<Class>();  
	    String packageNameSlashed = "/" + packageName.replace(".", "/"); 
	    // Get a File object for the package  
	    URL directoryURL = Thread.currentThread().getContextClassLoader().getResource(packageNameSlashed);  
	    System.out.println(Thread.currentThread().getContextClassLoader().getResource("."));
	    System.out.println(Thread.currentThread().getContextClassLoader().getResource("."));
	    if (directoryURL == null) {  
	        System.out.println("Could not retrieve URL resource: " + packageNameSlashed);  
	        return classes;  
	    }  
	  
	    String directoryString = directoryURL.getFile();  
	    if (directoryString == null) {  
	        System.out.println("Could not find directory for URL resource: " + packageNameSlashed);  
	        return classes;  
	    }  
	  
	    File directory = new File(directoryString);  
	    if (directory.exists()) {  
	        // Get the list of the files contained in the package  
	        String[] files = directory.list();  
	        for (String fileName : files) {  
	            // We are only interested in .class files  
	            if (fileName.endsWith(".class")) {  
	                // Remove the .class extension  
	                fileName = fileName.substring(0, fileName.length() - 6);  
	                try {  
	                    classes.add(Class.forName(packageName + "." + fileName));  
	                } catch (ClassNotFoundException e) {  
	                    System.out.println(packageName + "." + fileName + " does not appear to be a valid class.");  
	                }  
	            }  
	        }  
	    } else {  
	        System.out.println(packageName + " does not appear to exist as a valid package on the file system.");  
	    }  
	    return classes;  
	}  
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		System.out.println(getClassesInPackage("commandParsing"));
	}
}
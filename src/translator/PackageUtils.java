package translator;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class PackageUtils {

	private static boolean debug = true;

	private PackageUtils() {}

	public static List<String> getClasseNamesInPackage (String jarName, String packageName){
		ArrayList<String> classes = new ArrayList<String> ();

		packageName = packageName.replaceAll("\\." , "/");
		if (debug) System.out.println
		("Jar " + jarName + " looking for " + packageName);
		try{
			JarInputStream jarFile = new JarInputStream (new FileInputStream (jarName));
			JarEntry jarEntry;

			while(true) {
				jarEntry=jarFile.getNextJarEntry ();
				if(jarEntry == null){
					break;
				}
				if((jarEntry.getName ().startsWith (packageName)) &&
						(jarEntry.getName ().endsWith (".class")) ) {
					if (debug) System.out.println
					("Found " + jarEntry.getName().replaceAll("/", "\\."));
					classes.add (jarEntry.getName().replaceAll("/", "\\."));
				}
			}
		}
		catch( Exception e){
			e.printStackTrace ();
		}
		return classes;
	}

	public static void main (String[] args){
		List<String> list =  PackageUtils.getClasseNamesInPackage ("C:/Users/Stanley Yuan/Dropbox/workspace/slogo_team10/SLOGOStanley.jar", "commandParsing");
		System.out.println(list);
	}
}

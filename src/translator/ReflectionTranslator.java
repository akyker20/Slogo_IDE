package translator;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ReflectionTranslator {
	public static final String JAR_NAME = "SLOGO.Jar";
	public static final String PACKAGE_NAME = "commandParsing";
	private ReflectionTranslator() {
		getClassNamesInPackage(JAR_NAME, PACKAGE_NAME);
	}

	public static Map<String, String> getClassNamesInPackage(String jarName,
			String packageName) {
		ArrayList<String> classes = new ArrayList<String>();
		Map<String, String> classDictionary = new HashMap<String, String>();
		

		packageName = packageName.replaceAll("\\.", "/");
		try {
			JarInputStream jarFile = new JarInputStream(new FileInputStream(
					jarName));
			JarEntry jarEntry;

			while (true) {
				jarEntry = jarFile.getNextJarEntry();
				if (jarEntry == null) {
					break;
				}
				if ((jarEntry.getName().startsWith(packageName))
						&& (jarEntry.getName().endsWith(".class"))) {
					String pathName = jarEntry.getName().replaceAll("/", "\\.");
					classDictionary.put(findCommandName(pathName), pathName);
				}
			}
			jarFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return classDictionary;

		// return classes;
	}

	public static void main(String[] args) {
		List<String> list = PackageUtils.getClasseNamesInPackage(
				"SLOGOStanley.jar", "commandParsing");
		System.out.println(list);
	}

	public static String findCommandName(String command) {

		String folders[] = command.split(".");

		return folders[folders.length - 2];

	}
}

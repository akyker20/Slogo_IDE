package translator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class Translator {

	private static Map<String, String> dictionary = new HashMap<String, String>();
	private static Map<String, String> classDictionary = new HashMap<String, String>();

	public Translator(String language) throws IOException {
		
		changeLanguage(language);

	}

	protected static Map<String,String> changeLanguage(String language)
			throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				"src/resources/languages/" + language + ".properties")));
		String inputLine = null;
		while ((inputLine = reader.readLine()) != null) {

			inputLine = inputLine.replace(" ", "");

			String[] commands = inputLine.split("=");

			// Ignore empty lines and comment lines
			if (inputLine.equals("") || inputLine.startsWith("#"))
				continue;

			if (inputLine.contains(",")) {
				String[] multipleCommandsOneAction = commands[1].split(",");
				for (int i = 0; i < multipleCommandsOneAction.length; i++) {
					dictionary.put(multipleCommandsOneAction[i], commands[0]);
				}
			} else {
				dictionary.put(commands[1], commands[0]);
			}

		}
		// Printing all words stored in the map.
		for (String key : dictionary.keySet()) {
			System.out.println(key + ": " + dictionary.get(key));
		}
		
		reader.close();
		
		return dictionary;
	}
	
	public static Map<String, String> getClassNamesInPackage(String jarName,
			String packageName) throws FileNotFoundException, IOException {
		packageName = packageName.replaceAll("\\.", "/");
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

		return classDictionary;
	}
	
	public static String findCommandName(String command) {

		String folders[] = command.split(".");

		return folders[folders.length - 2];

	}

}

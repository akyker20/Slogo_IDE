package translator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Translator {

	private Map<String, String> dictionary = new HashMap<String, String>();

	public Translator(String language) throws IOException {

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

	}

}

package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;
	private static final String DEFAULT_OUT = "result.out";

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();

				if (result.isEmpty()) {
					throw new IllegalStateException("The symtomps.txt file is Empty, so result.out is Not Written");
				}

			} catch (IOException e) {
				System.err.println("ERROR ACCESS FILE : 'symptoms.txt'");
				e.printStackTrace();
			}
		}

		return result;
	}
	/**
	 * Create a map with the number of symptoms sorted in alphabetic order.
	 **/ 
	public Map<String, Integer> countNumberSymptoms(List<String> listFromFile) {
		TreeMap<String, Integer> mapSymptoms = new TreeMap<>();
		if (listFromFile != null && !listFromFile.isEmpty()) {
			for (String temp : listFromFile) {
				mapSymptoms.put(temp, !mapSymptoms.containsKey(temp) ? 1 : (mapSymptoms.get(temp) + 1));
			}
		}
		return mapSymptoms;
	}

	public void result(Map<String, Integer> res) throws IOException {
		FileWriter writer = new FileWriter(DEFAULT_OUT);               // Write in the result file.
		for (Map.Entry<String, Integer> entry : res.entrySet()) {
			try {
				writer.write(entry.getKey() + "=" + entry.getValue());
				writer.write(System.getProperty("line.separator"));
			} catch (IOException e) {
				System.err.println("Error Access Of result.out File");
				e.printStackTrace();
			}
		}
		writer.close();
		System.out.println("The 'result.out' File is Successfully Written");
	}
}

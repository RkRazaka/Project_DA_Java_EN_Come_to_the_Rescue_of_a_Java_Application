package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	
	ReadSymptomDataFromFile readSymptomDataFromFile;
	private static String symptomsfile  = "symptoms.txt";
	
	public AnalyticsCounter() {
		readSymptomDataFromFile = new ReadSymptomDataFromFile(symptomsfile);
	}

	private List<String> reader() {
		return readSymptomDataFromFile.getSymptoms();
	}
	
	public Map<String, Integer> counter() {
		return readSymptomDataFromFile.countNumberSymptoms(this.reader());
	}
	
	public void outputFile(Map<String, Integer> res) throws IOException {
		readSymptomDataFromFile.result(res);
	}
	
}

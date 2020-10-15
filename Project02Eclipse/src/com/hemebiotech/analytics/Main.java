package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		// Setup a list from the symptoms file, analyse "symtoms.txt" file
		Map<String, Integer> countEstablished = analyticsCounter.counter();
		// Put All Occurrence In "result.out" File
		analyticsCounter.outputFile(countEstablished);
	}
}

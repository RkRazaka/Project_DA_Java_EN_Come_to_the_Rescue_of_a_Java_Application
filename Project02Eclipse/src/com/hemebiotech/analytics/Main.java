package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * 
 * @author OC
 * @version : 1.0.2
 * 
 */

public class Main {

	public static void main(String[] args) throws IOException {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		// Analyse "symtoms.txt" File
		Map<String, Integer> countEstablished = analyticsCounter.counter();
		// Put All Occurrence In "result.out" File
		analyticsCounter.outputFile(countEstablished);

	}

}

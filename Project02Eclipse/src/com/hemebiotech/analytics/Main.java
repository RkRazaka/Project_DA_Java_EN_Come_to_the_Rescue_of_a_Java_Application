package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		Map<String, Integer> countEstablished = analyticsCounter.counter();
		analyticsCounter.outputFile(countEstablished);

	}

}
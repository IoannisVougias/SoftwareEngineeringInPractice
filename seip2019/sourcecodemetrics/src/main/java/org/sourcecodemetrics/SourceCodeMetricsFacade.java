package org.sourcecodemetrics;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SourceCodeMetricsFacade {
	

	public static ArrayList<String> readSourceCode(String file) throws FileNotFoundException {
		ArrayList<String> list = SourceCodeMetricsUtility.readFile(file);
		return list;
	}

	public static ArrayList<String> calculateMetrics(ArrayList<String> list, String typeofanalysis) {
		SourceCodeMetricsGenericAnalyzer analyzer = SourceCodeMetricsFactory.getAnalyzer(typeofanalysis);
		ArrayList<String> results = analyzer.calculateMetrics(list);
		return results;

	}

	public static void writeCSV(ArrayList<String> results ) {
		 SourceCodeMetricsUtility.writeFile("metrics.csv", results);
	}
}

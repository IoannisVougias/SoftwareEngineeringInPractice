package org.sourcecodemetrics;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/***
 * 
 * @author IoannisVougias The purpose of this facade class is to call all the
 *         necessary classes and methods to write the CSV file
 * 
 */
public class SourceCodeMetricsFacade {
	/**
	 * This method reads the java file
	 * 
	 * @param file that contains the input java file
	 * @return list that contains the file in separate line strings
	 */

	public static ArrayList<String> readSourceCode(String file) throws FileNotFoundException {
		ArrayList<String> list = SourceCodeMetricsUtility.readFile(file);
		return list;
	}

	/**
	 * This method calculates the metrics
	 * 
	 * @param list           the list that contains the file in separate line
	 *                       strings
	 * @param typeofanalysis string or regex
	 * @return results which is the metrics
	 */

	public static ArrayList<String> calculateMetrics(ArrayList<String> list, String typeofanalysis) {
		SourceCodeMetricsGenericAnalyzer analyzer = SourceCodeMetricsFactory.getAnalyzer(typeofanalysis);
		ArrayList<String> results = analyzer.calculateMetrics(list);
		return results;

	}

	/**
	 * This method writes the CSV file with the metrics
	 * 
	 * @param results
	 */

	public static void writeCSV(ArrayList<String> results) {
		SourceCodeMetricsUtility.writeFile("metrics.csv", results);
	}
}

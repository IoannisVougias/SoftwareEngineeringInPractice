package org.sourcecodemetrics;

import java.util.ArrayList;

/***
 * 
 * @author IoannisVougias The purpose of this class is a Strategy Pattern that
 *         executes the appropriate analyzer
 * 
 */
public abstract class SourceCodeMetricsGenericAnalyzer {

	static int loc = 0;
	static int numofmethods = 0;
	static int numofclasses = 0;

	/**
	 * This method calculates the metrics from the list that contains the file
	 * 
	 * @param file contains the file in lines
	 * @return results contains the metrics that are calculates
	 */

	public ArrayList<String> calculateMetrics(ArrayList<String> file) {

		ArrayList<String> results = null;

		return results;

	}

}

package org.sourcecodemetrics;

/***
 * 
 * @author IoannisVougias The purpose of this factory class is to pick the
 *         appropriate metric analyzer according to the cmd input
 * 
 */
public class SourceCodeMetricsFactory {

	/**
	 * This method returns the appropriate metrics analyzer
	 * 
	 * @param analyzetype which is either string or regex
	 * @return the correct analyzer
	 */

	public static SourceCodeMetricsGenericAnalyzer getAnalyzer(String analyzetype) {
		if (analyzetype.contentEquals("string")) {
			return new StringComparison();
		}
		if (analyzetype.contentEquals("regex")) {
			return new RegularExpressions();

		}
		return null;
	}
}

package org.sourcecodemetrics;

public class SourceCodeMetricsFactory {

	public static SourceCodeMetricsGenericAnalyzer getAnalyzer(String analyzetype) {
		if(analyzetype.contentEquals("string")) {
			return new StringComparison();
		}
		if(analyzetype.contentEquals("regex")) {
			return new RegularExpressions();
			
		}
		return null;
	}
}

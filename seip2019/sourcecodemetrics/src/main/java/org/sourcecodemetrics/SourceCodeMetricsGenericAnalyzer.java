package org.sourcecodemetrics;

import java.util.ArrayList;

public interface SourceCodeMetricsGenericAnalyzer {

	public ArrayList<String> calculateMetrics(ArrayList<String> file);

}

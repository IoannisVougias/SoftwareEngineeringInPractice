package org.sourcecodemetrics;

import java.util.ArrayList;

public class StringComparison implements SourceCodeMetricsGenericAnalyzer {

	public ArrayList<String> calculateMetrics(ArrayList<String> file) {
		ArrayList<String> metrics = new ArrayList<String>();
		int loc = 0;
		int numofclasses = 0;
		String substring = "class";
		int numofmethods = 0;
		for (int i = 0; i < file.size(); i++) {

			if (file.get(i).contains(substring)) {
				numofclasses++;

			}

			if (!file.get(i).equals("")) {
				if (!file.get(i).contains("/*")) {
					if (!file.get(i).contains("*/")) {
						if (!file.get(i).contains("*"))

							loc++;
					}
				}

			}

			if (file.get(i).contains("public") && file.get(i).contains("{") && file.get(i).contains("(")
					&& file.get(i).contains(")")) {
				numofmethods++;

			}
			if (file.get(i).contains("private") && file.get(i).contains("{") && file.get(i).contains("(")
					&& file.get(i).contains(")")) {
				numofmethods++;

			}

			if (file.get(i).contains("protected") && file.get(i).contains("{") && file.get(i).contains("(")
					&& file.get(i).contains(")")) {
				numofmethods++;

			}

		}

		metrics.add(String.valueOf(loc));
		metrics.add(String.valueOf(numofclasses));
		metrics.add(String.valueOf(numofmethods));
		return metrics;
	}

}

package org.sourcecodemetrics;

import java.util.ArrayList;

/***
 * 
 * @author IoannisVougias The purpose of this class is to calculates lines of
 *         code, number of methods and number of classes through string
 *         comparison method
 * 
 */

public class StringComparison extends SourceCodeMetricsGenericAnalyzer {

	/**
	 * This method calculates the lines of code, number of methods and number of
	 * classes in the given file.
	 * 
	 * @param file the list with string lines of the file
	 * @return metrics a list with the results
	 */

	public ArrayList<String> calculateMetrics(ArrayList<String> file) {
		ArrayList<String> metrics = new ArrayList<String>();
		String substring = "class";
		for (int i = 0; i < file.size(); i++) {

			if (!file.get(i).equals("")) {
				if (!file.get(i).contains("/*")) {
					if (!file.get(i).contains("*/")) {
						if (!file.get(i).contains("*")) {

							loc++;
							if (file.get(i).trim().contains(substring)) {
								numofclasses++;

							}
						}

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
		metrics.add(String.valueOf(numofmethods));
		metrics.add(String.valueOf(numofclasses));
		return metrics;
	}

}

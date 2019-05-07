package org.sourcecodemetrics;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * 
 * @author IoannisVougias The purpose of this class is to calculate the lines of
 *         code, number of methods, number of classes through Regular
 *         Expressions
 * 
 */

public class RegularExpressions extends SourceCodeMetricsGenericAnalyzer {

	/**
	 * This method calculates the metrics of the java file. The metrics are lines of
	 * code, number of methods, number of classes
	 * 
	 * @param file the java file that the metrics will be calculated
	 * @return metrics An Array List with the metrics
	 */
	public ArrayList<String> calculateMetrics(ArrayList<String> file) {
		/* Initialize the List */
		ArrayList<String> metrics = new ArrayList<String>();

		/*
		 * Parse the file ,count the lines that doesn't start with the regex in the
		 * parenthesis
		 */

		for (int i = 0; i < file.size(); i++) {
			Pattern lines = Pattern.compile("^(\\\\*|^/|^\\\\s(?!($))^(?!(\\\\*))^(?!(/))+)");
			Matcher matcher = lines.matcher(file.get(i));
			/* count lines of code */
			while (matcher.find())
				loc++;
			/* Count the methods */

			Pattern methods = Pattern.compile(
					"((public|private|protected|static|final|native|synchronized|abstract|transient)+\\s)+[\\$_\\w\\<\\>\\[\\]]*\\s+[\\$_\\w]+\\([^\\)]*\\)?\\s*\\{?[^\\}]*\\}?");
			Matcher matcher1 = methods.matcher(file.get(i));
			while (matcher1.find())
				numofmethods++;

			Pattern classes = Pattern.compile("\\bclass\\b");
			Matcher matcher2 = classes.matcher(file.get(i));
			while (matcher2.find())
				numofclasses++;

		}
		metrics.add(String.valueOf(loc));
		metrics.add(String.valueOf(numofmethods));
		metrics.add(String.valueOf(numofclasses));

		return metrics;
	}
}

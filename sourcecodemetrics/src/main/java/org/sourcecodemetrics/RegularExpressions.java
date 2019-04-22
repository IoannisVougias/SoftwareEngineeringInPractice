package org.sourcecodemetrics;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions implements SourceCodeMetricsGenericAnalyzer {

	public ArrayList<String> calculateMetrics(ArrayList<String> file) {
		ArrayList<String> metrics = new ArrayList<String>();
		for (int i = 0; i < file.size(); i++) {
			Pattern lines = Pattern.compile("^(?!\\s*//)", Pattern.MULTILINE);
			Matcher matcher = lines.matcher(file.get(i));
			int loc = 0;
			while (matcher.find())
				loc++;

			Pattern methods = Pattern.compile(
					"((public|private|protected|static|final|native|synchronized|abstract|transient)+\\s)+[\\$_\\w\\<\\>\\[\\]]*\\s+[\\$_\\w]+\\([^\\)]*\\)?\\s*\\{?[^\\}]*\\}?",
					Pattern.MULTILINE);
			Matcher matcher1 = methods.matcher(file.get(i));
			int numofmethods = 0;
			while (matcher1.find())
				numofmethods++;

			metrics.add(String.valueOf(loc));
			// metrics.add(String.valueOf(numofclasses));
			metrics.add(String.valueOf(numofmethods));
			// Pattern classes =
			// Pattern.compile("((public|private|protected|static|final|native|synchronized|abstract|transient)+\\s)+[\\$_\\w\\<\\>\\[\\]]*\\s+[\\$_\\w]+\\([^\\)]*\\)?\\s*\\{?[^\\}]*\\}?",
			// Pattern.MULTILINE);
			// Matcher matcher1 = classes.matcher(file.get(i));
			// int numofclasses = 0;
			// while (matcher1.find())
			// numofclasses++;

		}
		return metrics;
	}
}

package org.sourcecodemetrics;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/***
 * 
 * @author IoannisVougias The purpose of this class is to be the main class that
 *         calls the appropriate classes
 * 
 */
public class TestSourceCodeMetrics {

	public static void main(String[] args) throws FileNotFoundException {
		String file = args[0];
		String analysis = args[1];
		SourceCodeMetricsFacade Facade = new SourceCodeMetricsFacade();
		ArrayList<String> list = Facade.readSourceCode(file);
		Facade.writeCSV(Facade.calculateMetrics(list, analysis));

	}

}

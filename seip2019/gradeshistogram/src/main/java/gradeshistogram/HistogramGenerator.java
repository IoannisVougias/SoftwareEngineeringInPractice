package gradeshistogram;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/***
 * 
 * @author IoannisVougias The purpose of this class is to present a histogram of
 *         grades based on a command line input txt file that includes grades
 * 
 */
public class HistogramGenerator {

	/***
	 * Receives a String. Initialises an Integer Array representing frequencies of
	 * each grade from 0-10 matching the index of the array. This methods opens the
	 * file reads it line by line converts the strings that this file contains into
	 * integers and adds them to the frequency array In the end it returns back the
	 * frequency array.
	 * 
	 * @param inputfile String that has the name of the grade txt file
	 */

	public static int[] readGrades(String inputfile) {
		/*
		 * Initialises frequency integer array with length=11 11 because we have 11
		 * numbers [0-10]
		 */
		int[] frequency = new int[11];
		/*
		 * Initialise inFile which is File type as null and creating a file object with
		 * the input string
		 */
		File inFile = null;
		inFile = new File(inputfile);
		/*
		 * exception handling. Initialising 2 variables integer pos and string line
		 * Reading the file line by line until it ends converting string line which is
		 * the grade into integer and assinging it to pos variable
		 * 
		 */
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(inFile));
			int pos; // here each time the line/grade will be assigned
			String line; // the string that represents the grade
			while ((line = br.readLine()) != null) {
				pos = Integer.parseInt(line); // conversion of string to int
				frequency[pos]++; // in index pos increase by 1
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		/*
		 * return the frequency array
		 */
		return frequency;
	}

	/***
	 * Receives a single dimension Integer array. From this array the dataset that
	 * will be used for the visualization is generated. Finally, The chart is
	 * generated with the use of the aforementioned dataset and then presented in
	 * the screen.
	 *
	 * @param dataValues Single dimension integer array
	 */
	public static void generateChart(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that can be
		 * visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many series in
		 * one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Histogram Of Grades", "Grade", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	/***
	 * Main method that take the file from command line assigns it in a string
	 * variable calls readGrades and assigns the output into Integer array
	 * datavalues. Then calls generateChart to draw the histogram based on the
	 * array.
	 * 
	 */
	public static void main(String[] args) {

		String gradesfile = args[0];
		int[] datavalues = readGrades(gradesfile);
		generateChart(datavalues);

	}

}

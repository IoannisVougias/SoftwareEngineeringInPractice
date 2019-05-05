package org.sourcecodemetrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/***
 * 
 * @author IoannisVougias The purpose of this class is to write and read a file
 *         serving as a file utilities
 * 
 */
public final class SourceCodeMetricsUtility {
	private static final String NEW_LINE_SEPARATOR = "\n";

	/**
	 * This method reads a file from a filepath
	 * 
	 * @param filepath the path of the file
	 * @return list that contains the file
	 * 
	 */

	public static ArrayList<String> readFile(String filepath) throws FileNotFoundException {
		Scanner s = new Scanner(new File(filepath));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNextLine()) {
			list.add(s.nextLine());
		}
		s.close();
		return list;
	}

	/**
	 * This method writes a file
	 * 
	 * @param filename the path that the file will be written
	 * @param content  is what will be written in the file
	 * 
	 */

	public static void writeFile(String filename, ArrayList<String> content) {
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(filename);

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			// Write a new student object list to the CSV file
			for (int i = 0; i < content.size(); i++) {
				fileWriter.append(content.get(i));
			}

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
	}
}

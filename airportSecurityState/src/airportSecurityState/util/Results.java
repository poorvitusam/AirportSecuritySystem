package src.airportSecurityState.util;

import src.airportSecurityState.util.MyLogger;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class Results implements FileDisplayInterface {
	private ArrayList<String> results;
	private FileProcessor fp;
	
	/**
	 * Assign file processor object
	 * @param fileProcessor
	 */
	public Results(FileProcessor fileProcessor) {
		MyLogger.writeMessage("Contructor of Results", MyLogger.DebugLevel.CONSTRUCTOR);
		fp = fileProcessor;
		results = new ArrayList<String>();
	}
	
	/**
	 * Call function to write in file 
	 */
	public void writeToFile(String s) {
		fp.writeLine(s);
	}
	
	public void writeToStdout(String s) {
		System.out.println(s);
	}
	
	/**
	 * Store entry in result object
	 * @param name of test
	 * @param result if passed or failed
	 * @param message if error then message
	 */
	public void writeResultToFile() {
		for(String entry:results) {
			writeToFile(entry);
		}
	}
	
	/**
	 * Form the the string with the node to store
	 * @param node B number and courses are extracted from here
	 */
	public void storeResult(String result) {
		results.add(result + "\n");
	}
}


package src.airportSecurityState.driver;

import src.airportSecurityState.util.FileProcessor;

public class Driver {
	/**
	 * main method
	 * @param args
	 */
	public static void main(String args[]) {
		if(args[0].equalsIgnoreCase("{arg0}") || args[1].equalsIgnoreCase("{arg1}") || args.length !=2) {
			System.err.println("Invalid arguments");
			System.exit(1);
		}
		
		String inputFile = args[0];
		String outputFile = args[1];
		
		FileProcessor reader = new FileProcessor(inputFile, "read", "read");;
		FileProcessor writer = new FileProcessor(outputFile, "write", "output");
		
	}
}

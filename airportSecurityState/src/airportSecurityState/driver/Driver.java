package src.airportSecurityState.driver;

import src.airportSecurityState.airportStates.AirportSecurityProcess;
import src.airportSecurityState.airportStates.SecurityStateContext;
import src.airportSecurityState.util.FileProcessor;
import src.airportSecurityState.util.Results;
import src.airportSecurityState.util.MyLogger;

public class Driver {
	/**
	 * main method
	 * @param args
	 */
	public static void main(String args[]) {
		
		if(args[0].equalsIgnoreCase("{arg0}") ||
				args[1].equalsIgnoreCase("{arg1}") ||
				args[2].equalsIgnoreCase("{arg2}") ||
				args.length !=3) {
			System.err.println("Invalid arguments");
			System.exit(1);
		}
		
		String inputFile = args[0];
		String outputFile = args[1];
		int debugLevel = Integer.parseInt(args[2]);
		
		MyLogger.setDebugValue(debugLevel);
		
		FileProcessor reader = new FileProcessor(inputFile, "read", "read");;
		FileProcessor writer = new FileProcessor(outputFile, "write", "output");
		
		Results result = new Results(writer);
		SecurityStateContext state = new SecurityStateContext();
		AirportSecurityProcess securityProcess = new AirportSecurityProcess(reader, state, result);
		
		result.writeResultToFile();
		
		reader.closeFile("read");
		writer.closeFile("write");
	}
}

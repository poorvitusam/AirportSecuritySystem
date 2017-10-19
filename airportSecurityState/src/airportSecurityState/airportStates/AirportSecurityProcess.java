package src.airportSecurityState.airportStates;

import java.util.ArrayList;

import src.airportSecurityState.util.FileProcessor;
import src.airportSecurityState.util.MyLogger;
import src.airportSecurityState.util.Results;

public class AirportSecurityProcess {
	private int total_num_of_travellers;
	private int total_num_of_days;
	private int total_num_of_prohibited_items;
	private int day = 0;
	private ArrayList<String> prohibited_items=new ArrayList<String>();
	
	public AirportSecurityProcess(FileProcessor fp, SecurityStateContext state, Results results) {
		MyLogger.writeMessage("Contructor of AirportSecurityProcess ", MyLogger.DebugLevel.CONSTRUCTOR);
		
		prohibited_items.add("Gun");
		prohibited_items.add("NailCutter");
		prohibited_items.add("Blade");
		prohibited_items.add("Knife");
		
		String nextLine;
		while ((nextLine = fp.readLine()) != null) {
			int index = nextLine.indexOf(";");
			int new_day = Integer.parseInt(nextLine.substring(4, index));
			if (new_day != day) {
				total_num_of_days ++;
				day = new_day;
				MyLogger.writeMessage("New Day Occured :: Day " + day, MyLogger.DebugLevel.FROM_RESULTS);
			}
			index = nextLine.lastIndexOf(":");
			String item = nextLine.substring(index+1);
			if(prohibited_items.contains(item)) {
				total_num_of_prohibited_items++;
				MyLogger.writeMessage("Prohibited Item Found :: " + item, MyLogger.DebugLevel.IN_RESULTS);
			}
			total_num_of_travellers++;
			securityProcess(state, results);
		}
	}
	
	public int getAverageTrafficPerDay() {
		return total_num_of_travellers / total_num_of_days;
	}
	
	public int getAverageProhibitedItemsPerDay() {
		return total_num_of_prohibited_items / total_num_of_days;
	}
	
	public void securityProcess(SecurityStateContext state, Results results) {
		int avg_traffic_per_day = getAverageTrafficPerDay();
		int avg_prohibited_items = getAverageProhibitedItemsPerDay();
		

		String LOW_RISK = "1 3 5 7 9";
		String MODERATE_RISK = "2 3 5 8 9";
		String HIGH_RISK = "2 4 6 8 10";
		
		AirportStateI finalState = state.tightenOrLoosenSecurity(avg_traffic_per_day, 
				avg_prohibited_items);
		if (finalState instanceof LowRisk) {
			results.storeResult(LOW_RISK);
		} else if (finalState instanceof ModerateRisk) {
			results.storeResult(MODERATE_RISK);
		} else {
			results.storeResult(HIGH_RISK);
		}
	}
}

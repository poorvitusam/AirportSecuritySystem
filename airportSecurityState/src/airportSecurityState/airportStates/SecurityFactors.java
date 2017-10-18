package src.airportSecurityState.airportStates;

import java.util.ArrayList;

import src.airportSecurityState.util.FileProcessor;

public class SecurityFactors {
//	private HashMap<String, Integer> instructionSequence = null;
//	private HashMap<String, Integer> instructionSequence = null;
	private int total_num_of_travellers;
	private int total_num_of_days;
	private int total_num_of_prohibited_items;
	private int day;
	String current_state;
	private ArrayList<String> prohibited_items=new ArrayList<String>();
	public static String LOW_RISK = "1 3 5 7 9";
	public static String MODERATE_RISK = "2 3 5 8 9";
	public static String HIGH_RISK = "2 4 6 8 10";
	
	public SecurityFactors(FileProcessor fp) {
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
			}
			index = nextLine.lastIndexOf(":");
			String item = nextLine.substring(index+1);
			if(prohibited_items.contains(item)) {
				total_num_of_prohibited_items++;
			}
		}
	}
	
	public int getAverageTrafficPerDay() {
		return total_num_of_travellers * total_num_of_days;
	}
	
	public int getAverageProhibitedItemsPerDay() {
		return total_num_of_prohibited_items * total_num_of_days;
	}
	
	public void checkAirportState() {
		int avg_traffic_per_day = getAverageTrafficPerDay();
		int avg_prohibited_items = getAverageProhibitedItemsPerDay();
		if(0 <= avg_traffic_per_day && avg_traffic_per_day < 4 || 0 <= avg_prohibited_items && avg_prohibited_items < 1) {
			current_state = LOW_RISK;
		}
		if(4 <= avg_traffic_per_day && avg_traffic_per_day < 8 || 1 <= avg_prohibited_items && avg_prohibited_items < 2) {
			current_state = MODERATE_RISK;
		}
		if(avg_traffic_per_day >= 8 || avg_prohibited_items >= 2) {
			current_state = HIGH_RISK;
		}
	}
}

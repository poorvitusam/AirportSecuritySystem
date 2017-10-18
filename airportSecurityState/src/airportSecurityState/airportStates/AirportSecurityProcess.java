package src.airportSecurityState.airportStates;

import java.util.ArrayList;

import src.airportSecurityState.util.FileProcessor;
import src.airportSecurityState.util.Results;

public class AirportSecurityProcess {
	private int total_num_of_travellers;
	private int total_num_of_days;
	private int total_num_of_prohibited_items;
	private int day;
	private ArrayList<String> prohibited_items=new ArrayList<String>();
	
	public AirportSecurityProcess(FileProcessor fp, SecurityState state, Results results) {
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
			securityProcess(state, results);
		}
	}
	
	public void securityProcess(SecurityState state, Results results) {
		String finalState = state.tightenOrLoosenSecurity(total_num_of_travellers, 
				total_num_of_days, total_num_of_prohibited_items);
		results.storeResult(finalState);
	}
}

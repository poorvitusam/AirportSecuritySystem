package src.airportSecurityState.airportStates;


import src.airportSecurityState.util.FileProcessor;

public class SecurityState {
	String current_state;
	public static String LOW_RISK = "1 3 5 7 9";
	public static String MODERATE_RISK = "2 3 5 8 9";
	public static String HIGH_RISK = "2 4 6 8 10";
	
	public int getAverageTrafficPerDay(int travellers, int days) {
		return travellers * days;
	}
	
	public int getAverageProhibitedItemsPerDay(int days, int prohobitedItems) {
		return prohobitedItems * days;
	}
	
	public void tightenOrLoosenSecurity(int travellers, int days, int prohobitedItems) {
		int avg_traffic_per_day = getAverageTrafficPerDay(travellers, days);
		int avg_prohibited_items = getAverageProhibitedItemsPerDay(days, prohobitedItems);
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

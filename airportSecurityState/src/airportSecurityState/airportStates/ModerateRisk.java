package src.airportSecurityState.airportStates;

public class ModerateRisk implements AirportStateI{
	AirportStateI currentState;
	public AirportStateI tightenOrLoosenSecurity(int avg_traffic_per_day, int avg_prohibited_items) {
		if(0 <= avg_traffic_per_day && avg_traffic_per_day < 4 ||
				0 <= avg_prohibited_items && avg_prohibited_items < 1) {
			
			currentState = new LowRisk();
		}
		if(4 <= avg_traffic_per_day && avg_traffic_per_day < 8 ||
				1 <= avg_prohibited_items && avg_prohibited_items < 2) {
			currentState = new ModerateRisk();
		}
		if(avg_traffic_per_day >= 8 || avg_prohibited_items >= 2) {
			currentState = new HighRisk();
		}
		return currentState;
	}
}

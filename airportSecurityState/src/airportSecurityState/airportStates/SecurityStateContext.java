package src.airportSecurityState.airportStates;

public class SecurityStateContext implements AirportStateI {
	AirportStateI currentState = new LowRisk();
	
	public AirportStateI tightenOrLoosenSecurity(int avg_traffic_per_day, int avg_prohibited_items) {
		currentState = currentState.tightenOrLoosenSecurity(avg_traffic_per_day, avg_prohibited_items);
		return currentState;
	}
}

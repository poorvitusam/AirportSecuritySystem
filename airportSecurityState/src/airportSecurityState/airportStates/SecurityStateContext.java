package src.airportSecurityState.airportStates;

import src.airportSecurityState.util.MyLogger;

public class SecurityStateContext implements AirportStateI {
	AirportStateI currentState = new LowRisk();
	
	public SecurityStateContext() {
		MyLogger.writeMessage("Contructor of SecurityStateContext ", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	public AirportStateI tightenOrLoosenSecurity(int avg_traffic_per_day, int avg_prohibited_items) {
		currentState = currentState.tightenOrLoosenSecurity(avg_traffic_per_day, avg_prohibited_items);
		return currentState;
	}
}

package src.airportSecurityState.airportStates;

import src.airportSecurityState.util.MyLogger;

public class LowRisk implements AirportStateI{
	AirportStateI currentState;
	public LowRisk() {
		MyLogger.writeMessage("Contructor of LowRisk ", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	public AirportStateI tightenOrLoosenSecurity(int avg_traffic_per_day, int avg_prohibited_items) {
		AirportStateI previousState  = currentState;
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
		
		if(!(currentState instanceof LowRisk)) {
			MyLogger.writeMessage("State Changed ", MyLogger.DebugLevel.IN_RUN);
		}
		return currentState;
	}
}

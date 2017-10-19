package src.airportSecurityState.airportStates;

import src.airportSecurityState.util.MyLogger;

public class ModerateRisk implements AirportStateI{
	AirportStateI currentState;
	public ModerateRisk() {
		MyLogger.writeMessage("Contructor of ModerateRisk ", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
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
		
		if(!(currentState instanceof ModerateRisk)) {
			MyLogger.writeMessage("State Changed :: Previous State was ModerateRisk", MyLogger.DebugLevel.IN_RUN);
		}
		return currentState;
	}
}

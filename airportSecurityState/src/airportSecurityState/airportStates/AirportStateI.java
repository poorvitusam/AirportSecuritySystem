package src.airportSecurityState.airportStates;

public interface AirportStateI {
	AirportStateI tightenOrLoosenSecurity(int avg_traffic_per_day, int avg_prohibited_items);
}

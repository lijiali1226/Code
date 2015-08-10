package quizz.flight;

import java.util.Calendar;

public class Flight {
	private String flightNumber;
	private String departure;
	private String destination;
	private Calendar departureTime;
	private Calendar arrivalTime;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime.getTime().toString();
	}

	public void setDepartureTime(Calendar departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime.getTime().toString();
	}

	public void setArrivalTime(Calendar arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void fly() {
		System.out.println("This is flight " + getFlightNumber() + " from " + getDeparture() + " to "
				+ getDestination() + ". Start at " + getDepartureTime() + ", estimated to arrive at "
				+ getArrivalTime());
	}
}

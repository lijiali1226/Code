package quizz.flight;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {
	public static void main(String args[]) {
		Flight flight = new Flight();
		flight.setFlightNumber("MU9845");
		flight.setDeparture("Kunming");
		flight.setDestination("Guangzhou");
		Calendar calendar = new GregorianCalendar();
		flight.setDepartureTime(calendar);
		Calendar calendar2 = new GregorianCalendar();
		calendar2.add(Calendar.HOUR, 2);
		flight.setArrivalTime(calendar2);
		flight.fly();

		Airline airline = new Airline();
		airline.setName("China Southern Airlines");
		airline.print();

		Airport airport = new Airport();
		airport.setName("Changshui International Airport");
		airport.setCity("Kunming");
		airport.print();

		Ticket ticket = new Ticket();
		ticket.setTicketNumber("SL6748743541");
		ticket.setPrice(1000);
		ticket.print();

		Passenger a = new Passenger();
		a.setName("Xiao Ming");
		a.setCustomerNumber("EO9238567430");
		a.speak();

		Staff b = new Staff();
		b.setName("Xiao Hong");
		b.setStaffNumber("IP2302597835");
		b.speak();
	}
}
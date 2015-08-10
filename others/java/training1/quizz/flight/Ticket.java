package quizz.flight;

public class Ticket {
	private String ticketNumber;
	private int price;

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void print() {
		System.out.println("The ticket number is " + getTicketNumber() + ", it costs RMB " + price);
	}

}

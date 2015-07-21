package quizz.flight;

public class Person {
	private String name;
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void speak(String s) {
		System.out.println(s);
	}

}

class Passenger extends Person {
	private String luggageNumber;
	private String customerNumber;

	public String getLuggageNumber() {
		return luggageNumber;
	}

	public void setLuggageNumber(String luggageNumber) {
		this.luggageNumber = luggageNumber;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public void speak() {
		super.speak("I am " + this.getName() + ", my customer number is "
				+ this.getCustomerNumber());
	}

}

class Staff extends Person {
	private String staffNumber;

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public void speak() {
		super.speak("I am " + this.getName() + ", my staff number is "
				+ this.getStaffNumber());
	}

}

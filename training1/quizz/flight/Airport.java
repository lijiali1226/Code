package quizz.flight;

public class Airport {
	private String name;
	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void print() {
		System.out.println("This is " + getName() + " in " + getCity());
	}
}

package quizz;

public class StudentEnum {
	private long id;
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	enum Gender {
		MALE, FEMALE;
		public boolean isMale() {
			return this == MALE;
		}

		public String toString() {
			return isMale() ? "I am a boy" : "I am a girl";

		}
	}

	public String toString() {
		return "I\'m No. " + getId() + ", my name is " + getName();

	}

	public static void main(String[] args) {
		StudentEnum student = new StudentEnum();
		student.setId(687415435);
		student.setName("Bob");
		Gender gender = Gender.MALE;
		System.out.println(student.toString());
		System.out.println(gender.toString());

	}

}

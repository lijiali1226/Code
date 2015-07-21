package quizz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Person {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void speak() {
		System.out.println("I\'m " + this.name + " and I\'m " + this.age + " years old");
	}

	public static void main(String args[]) {
		Person person = new Person();
		person.setName("xiaoming");

		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, (int) (Math.random() * 10 + 1990));
		cal.set(Calendar.MONTH, (int) (Math.random() * 12));

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("birth day(1-31):");
		int temp = input.nextInt();
		if (temp >= 1 && temp <= 31)
			cal.set(Calendar.DAY_OF_MONTH, temp);
		else
			cal.set(Calendar.DAY_OF_MONTH, (int) (Math.random() * 28 + 1));

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print("birthday: ");
		System.out.println(date.format(cal.getTime()));
		person.setAge(2015 - cal.get(Calendar.YEAR));
		person.speak();

	}
}

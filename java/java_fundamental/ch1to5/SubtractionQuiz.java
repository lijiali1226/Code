package ch1to5;

import java.util.Scanner;

public class SubtractionQuiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1 = (int) (Math.random() * 10);
		int number2 = (int) (Math.random() * 10);

		if (number1 < number2) {
			int tmp = number1;
			number1 = number2;
			number2 = tmp;
		}

		System.out.println("what is " + number1 + " - " + number2 + " ? ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int answer = input.nextInt();

		if (number1 - number2 == answer)
			System.out.println("You are correct!");
		else
			System.out.println("Your answer is wrong\n" + number1 + " - "
					+ number2 + " should be " + (number1 - number2));

	}

}

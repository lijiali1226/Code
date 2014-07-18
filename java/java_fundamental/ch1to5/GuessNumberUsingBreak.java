package ch1to5;

import java.util.Scanner;

public class GuessNumberUsingBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = (int) (Math.random() * 101);

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Guess a magic number between 0 and 100");

		while (true) {
			System.out.print("\n Enter your guess");
			int guess = input.nextInt();

			if (guess == number) {
				System.out.println("Yes, the numebr is " + number);
				break;
			} else if (guess > number)
				System.out.println("Your guess is too hign");
			else
				System.out.println("Your guess is too low");

		}
	}

}

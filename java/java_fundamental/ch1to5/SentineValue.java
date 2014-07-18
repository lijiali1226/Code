package ch1to5;

import java.util.Scanner;

public class SentineValue {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out
				.println("Enter an int value (the program exits if the input is 0): ");
		int data = input.nextInt();

		int sum = 0;
		while (data != 0) {
			sum += data;

			System.out
					.print("Enter an int value (the program exits if the input is 0): ");
			data = input.nextInt();
		}

		System.out.println("The sum is " + sum);
	}
}

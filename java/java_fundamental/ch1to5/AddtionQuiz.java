package ch1to5;
import java.util.Scanner;

public class AddtionQuiz {

	public static void main(String[] args) {
		/* produce random integer  */
		int number1 = (int)(System.currentTimeMillis() % 10);
		int number2 = (int)(System.currentTimeMillis() * 7 % 10);
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("what is " + number1 + " + " + number2 + " ? " );
		
		int answer = input.nextInt();
		System.out.println(number1 + " + " + number2 + " = " + answer + " is "
				+ (number1 + number2 == answer));

	}
}

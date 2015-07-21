package euler;

public class P012HighlyDivisibleTriangularNumber {

	public static void main(String[] args) {
		int i = 0, n = 0, j = 0;
		long number = 0L;
		for (i = 1; n <= 250; i++) {
			number += i;
			// System.out.println("number " + number + " i " + i);
			for (j = 1, n = 0; j * j <= number; j++) {
				if (number % j == 0) {
					// System.out.println("j " + j);
					n++;
				}
			}
		}
		System.out.println(number);
	}

}

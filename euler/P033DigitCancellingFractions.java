package euler;

public class P033DigitCancellingFractions {

	public static void main(String[] args) {

		int i, j, a = 0, b = 0;
		int numerator = 1, denominator = 1;
		for (i = 11; i < 100; i++) {
			for (j = i + 1; j < 100; j++) {
				if (i % 10 == j / 10 && i % 10 != i / 10 && j % 10 != j / 10 && i / 10 != j % 10 && i % 10 != 0
						&& j % 10 != 0) {
					a = i / 10;
					b = j % 10;
					if (Math.abs((float) a / b - (float) i / j) < 1E-10) {
						System.out.println(" i " + i + " j " + j + " a " + a + " b " + b);
						numerator *= i;
						denominator *= j;
						System.out.println(" de " + denominator + " nu " + numerator);
					}
				}
			}
		}

		for (i = numerator; i > 2; i--) {

			if (numerator % i == 0 && denominator % i == 0) {
				numerator /= i;
				denominator /= i;
				System.out.println(" de " + denominator + " nu " + numerator);
			}
		}
	}
}

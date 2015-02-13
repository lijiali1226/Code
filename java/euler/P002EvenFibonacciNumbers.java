package euler;

public class P002EvenFibonacciNumbers {

	public static void main(String args[]) {
		int a = 1, b = 2, sum = 0;
		for (; a < 4_000_000 && b < 4_000_000;) {
			if (a % 2 == 0)
				sum += a;
			if (b % 2 == 0)
				sum += b;
			a += b;
			b += a;
			// System.out.println(" sum " + sum + " a " + a + " b " + b);
		}
		System.out.println(sum);
	}
}

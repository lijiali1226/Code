package euler;

public class P034DigitFactorials {

	public static int countFactorials(int n) {
		int i = 0, product = 1;
		for (i = n; i >= 1; i--) {
			product *= i;
		}
		return product;
	}

	public static int sumFactorials(int n) {
		int sum = 0;
		for (; n / 10 > 0; n /= 10) {
			sum += countFactorials(n % 10);
		}
		sum += countFactorials(n);
		return sum;
	}

	public static void main(String args[]) {
		int i = 10, sum = 0;
		for (i = 10; i < 10_000_000; i++) {
			if (sumFactorials(i) == i)
				sum += i;
		}
		System.out.println(sum);
	}
}

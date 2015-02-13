package euler;

public class P027QuadraticPrimes {

	public static boolean isPrime(int n) {
		int i = 0;
		if (n < 0)
			n = -n;
		for (i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int countPrimeNumber(int a, int b) {
		int i = 0, count = 0;
		for (i = 0;; i++) {
			if (isPrime(i * i + a * i + b)) {
				count++;
				// System.out.println(i * i + a * i + b + " " + count);
			} else
				break;
		}
		return count;
	}

	public static void main(String[] args) {
		int a = 0, b = 0, max = 0, product = 0;
		for (a = -999; a < 1000; a++) {
			for (b = -999; b < 1000; b++) {
				int temp = countPrimeNumber(a, b);
				if (max < temp) {
					max = temp;
					System.out.println(" a " + a + " b " + b + " max " + max);
					product = a * b;
				}
			}
		}
		System.out.println(product);
	}

}

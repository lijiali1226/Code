package euler;

public class P00710001stPrime {

	public static boolean isPrime(int n) {
		int i = 0;
		for (i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				// System.out.println("false " + n);
				return false;
			}
		}
		// System.out.println("true " + n);
		return true;
	}

	public static void main(String args[]) {
		int i = 0, n = 0;
		for (i = 2; n < 10_001; i++) {
			if (isPrime(i)) {
				n++;
				// System.out.println(" i " + i + " n " + n);
			}
		}
		System.out.println(i - 1);
	}
}

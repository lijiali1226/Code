package euler;

public class P035CircularPrimes {

	public static boolean isPrime(int n) {
		int i = 0;
		for (i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int i = 0, n = 0, j = 0, count = 0;
		String s = "";

		for (i = 100; i < 1_000_000; i++) {
			if (isPrime(i)) {
				s = Integer.toString(i);
				n = s.length();
				j = 0;
				while (j < n - 1) {
					s = s.substring(n - 1) + s.substring(0, n - 1);
					// System.out.println("rotation " + s);
					if (isPrime(Integer.parseInt(s))) {
						j++;
					} else
						break;
					// System.out.println("j " + j);
				}

				if (j == n - 1) {
					count++;
					// System.out.println(i +" "+"count " + count);
				}
			}
		}
		// System.out.println(count);
		count += 13;// thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97
		System.out.println(count);
	}
}

package euler;

public class P037TruncatablePrimes {

	public static boolean isPrime(int n) {
		int i = 0;
		if (n == 1)
			return false;
		for (i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static boolean isTruncatable(int n) {
		int i, count = 0;
		for (i = n; i / 10 >= 1; i /= 10) {
			count++;
			if (!isPrime(i)) {
				return false;
			}
		}
		if (!isPrime(i)) {
			return false;
		}
		for (i = n; count > 0; count--) {
			i %= (int) Math.pow(10, count);
			if (!isPrime(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		int i = 0, count = 0, sum = 0;
		for (i = 10; count < 11; i++) {
			if (isTruncatable(i)) {
				count++;
				System.out.println(i);
				sum += i;
			}
		}
		System.out.println(sum);
	}

}

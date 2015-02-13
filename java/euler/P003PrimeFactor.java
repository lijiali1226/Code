package euler;

public class P003PrimeFactor {

	public static void main(String args[]) {
		int i;
		// System.out.println(Long.MAX_VALUE);
		long n = 600851475143L;
		for (i = 1; i < n; i++) {
			if (n % i == 0) {
				n /= i;
				System.out.println(" n " + n + " i " + i);
			}
		}
		System.out.println(n);
	}
}

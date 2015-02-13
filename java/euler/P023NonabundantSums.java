package euler;

public class P023NonabundantSums {

	public static boolean isAbundant(int n) {
		int i = 0, sum = 1;
		for (i = 2; i * i < n; i++) {
			if (n % i == 0)
				sum += i + n / i;
		}
		if (i * i == n)
			sum += i;
		// System.out.println(n+" "+sum);
		if (sum > n)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int i = 0, j = 0, n = 0;
		final int N = 28123;
		int abundant[] = new int[N];

		for (i = 1; i < N; i++) {
			if (isAbundant(i)) {
				abundant[j++] = i;
			}
		}
		// for (i = 0; i < j; i++) {
		// System.out.println(abundant[i]+" "+i);
		// }

		// *******************************version1 much slower********************************
		// int length = j, sum = 0;
		// out: for (n = 1; n <= N; n++) {
		// for (i = 0; i < length; i++) {
		// for (j = i; j < length; j++) {
		// if (n == abundant[i] + abundant[j]) {
		// continue out;
		// }
		// }
		// }
		// sum += n;
		// }
		// *************************************************************************************

		int length = j, sum = 0;
		boolean[] number = new boolean[N];
		for (i = 0; i < length; i++) {
			for (j = i; j < length; j++) {
				n = abundant[i] + abundant[j];
				if (n < N && number[n] == false) {
					number[n] = true;
				}
			}
		}
		for (i = 1; i < N; i++) {
			if (number[i] == false)
				sum += i;
		}

		System.out.println(sum);

	}
}

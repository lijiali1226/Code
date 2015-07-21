package euler;

import java.util.ArrayList;

public class P046GoldbachsOtherConjecture {

	public static boolean judge(int n, ArrayList<Integer> primelist) {
		int i = 0, j = 0;
		for (i = 1; i * i < n / 2; i++) {
			for (j = 0; primelist.get(j) <= n - 2 * i * i; j++) {
				if (n == primelist.get(j) + 2 * i * i) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int i = 0;
		ArrayList<Integer> primelist = new ArrayList<Integer>();
		for (i = 2; i < 1_000_000; i++) {
			if (P00710001stPrime.isPrime(i))
				primelist.add(i);
		}
		for (i = 9; i < 1_000_000; i += 2) {
			if (!primelist.contains(i)) {
				if (!judge(i, primelist)) {
					System.out.println(i);
					break;
				}
			}
		}
	}

}

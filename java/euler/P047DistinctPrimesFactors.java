package euler;

import java.util.ArrayList;

public class P047DistinctPrimesFactors {

	public static void main(String[] args) {
		int i = 0, n = 0;
		ArrayList<Integer> primelist = new ArrayList<Integer>();
		for (i = 2; i < 1_000; i++) {
			if (P050ConsecutivePrimeSum.isPrime(i)) {
				primelist.add(i);
			}
		}

		for (i = 0; i * i < n; i++) {

		}

	}

}

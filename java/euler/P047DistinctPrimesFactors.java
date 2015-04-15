package euler;

import java.util.ArrayList;

public class P047DistinctPrimesFactors {

	public static void main(String[] args) {
		int n = 150_000;
		ArrayList<Integer> primelist = new ArrayList<Integer>();
		ArrayList<Integer> answerlist = new ArrayList<Integer>();
		for (int i = 2; i < 1_000; i++) {
			if (P050ConsecutivePrimeSum.isPrime(i)) {
				primelist.add(i);
				// System.out.println(i);
			}
		}

		for (int i = 2 * 644; i < n; i++) {
			int count = 0, temp = i;
			for (int j = 0; j < primelist.size(); j++) {
				if (temp % primelist.get(j) == 0 && temp != 1) {
					while (temp % primelist.get(j) == 0) {
						temp /= primelist.get(j);
					}
					count++;
				}
			}
			if (count == 4) {
				answerlist.add(i);
				// System.out.println(i);
			}
		}

		for (int k = 0; k + 3 < answerlist.size(); k++) {
			if (answerlist.get(k + 3) - answerlist.get(k) == 3) {
				System.out.println(answerlist.get(k));
			}
		}

	}

}

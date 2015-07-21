package euler;

import java.util.ArrayList;

public class P049PrimePermutations {

	public static ArrayList<Integer> primeList() {
		int i = 0;
		ArrayList<Integer> primelist = new ArrayList<Integer>();
		for (i = 1_000; i < 10_000; i++) {
			if (P050ConsecutivePrimeSum.isPrime(i)) {
				primelist.add(i);
			}
		}
		return primelist;
	}

	public static void main(String[] args) {
		ArrayList<Integer> primelist = primeList();
		int i = 0, j = 0, n = 0;
		for (; i < primelist.size(); i++) {
			for (j = i + 1; j < primelist.size(); j++) {
				if (isPermutation(primelist.get(i), primelist.get(j))) {
					n = primelist.get(j) - primelist.get(i);
					if (isPermutation(primelist.get(i), primelist.get(j) + n)
							&& primelist.contains(primelist.get(j) + n)) {
						System.out.println(primelist.get(i) + " " + primelist.get(j) + " " + (primelist.get(j) + n));
					}
				}
			}
		}
	}

	private static boolean isPermutation(Integer integer, Integer integer2) {
		ArrayList<Character> list = new ArrayList<Character>();
		String temp = integer.toString(), temp2 = integer2.toString();
		int i = 0;
		for (i = 0; i < temp.length(); i++) {
			list.add(temp.charAt(i));
		}
		for (i = 0; i < temp2.length(); i++) {
			if (!list.remove((Object) temp2.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}

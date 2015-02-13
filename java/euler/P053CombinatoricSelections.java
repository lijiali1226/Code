package euler;

import java.math.BigInteger;

public class P053CombinatoricSelections {

	public static String countCombinatoric(int n, int r) {
		return countFactorials(n).divide(countFactorials(r).multiply(countFactorials(n - r))).toString();
	}

	private static BigInteger countFactorials(int n) {
		BigInteger product = BigInteger.ONE;
		int i = 0;
		for (i = n; i >= 2; i--) {
			product = product.multiply(BigInteger.valueOf(i));
		}
		return product;
	}

	public static void main(String[] args) {
		int i = 0, j = 0, count = 0;
		for (i = 1; i <= 100; i++) {
			for (j = i; j <= 100; j++) {
				// System.out.println(countCombinatoric(j, i));
				if (countCombinatoric(j, i).length() > 6) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}

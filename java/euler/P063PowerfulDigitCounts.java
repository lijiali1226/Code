package euler;

import java.math.BigInteger;

public class P063PowerfulDigitCounts {

	public static BigInteger pow(int i, int j) {
		BigInteger n = BigInteger.ONE;
		for (; j > 0; j--) {
			n = n.multiply(BigInteger.valueOf(i));
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, count = 0;
		for (i = 1; i < 10; i++) {// We only iterate integers in [1,9] since 10**n has n+1 digits.
			for (j = 1; j < 50; j++) {
				if (String.valueOf(pow(i, j)).length() == j) {
					System.out.println(i + " " + j + " " + pow(i, j));
					count++;
				}
			}
		}
		System.out.println(count);
	}

}

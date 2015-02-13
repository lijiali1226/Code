package euler;

import java.math.BigInteger;

public class P048SelfPowers {

	public static void main(String[] args) {
		int i = 0;
		BigInteger temp = BigInteger.ONE;
		BigInteger sum = BigInteger.ZERO;

		for (i = 1; i <= 1000; i++) {
			temp = BigInteger.valueOf(i);
			temp = temp.pow(i);
			sum = sum.add(temp);
		}

		String s = sum.toString();

		System.out.println(s.substring(s.length() - 10));

	}
}

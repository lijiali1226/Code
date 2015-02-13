package euler;

import java.math.BigInteger;

public class P097LargeNonMersennePrime {

	public static void main(String[] args) {
		// ******************************version1***************************************
		BigInteger n = BigInteger.valueOf(2);
		String s = "";
		s = n.modPow(BigInteger.valueOf(7830457), BigInteger.valueOf((long) Math.pow(10, 10)))
				.multiply(BigInteger.valueOf(28433)).add(BigInteger.ONE).toString();
		s = s.substring(s.length() - 10);
		System.out.println(s);

		// *******************************version2*************************************
		int i = 0;
		long m = 1, k = (long) Math.pow(10, 10);
		for (i = 0; i < 7830457; i++) {
			m = m * 2 % k;
		}
		System.out.println(m * 28433 % k + 1);
	}
}

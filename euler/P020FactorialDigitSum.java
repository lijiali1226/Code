package euler;

import java.math.BigInteger;

public class P020FactorialDigitSum {

	public static void main(String[] args) {
		int i = 1, n = 100;
		BigInteger product = BigInteger.ONE;
		String s = "";
		for (i = 1; i < n; i++) {
			product = product.multiply(BigInteger.valueOf(i));
		}

		s = product.toString();
		n = 0;
		for (i = 0; i < s.length(); i++) {
			n += s.charAt(i) - '0';
		}

		System.out.println(n);
	}

}

package euler;

import java.math.BigInteger;

public class P0251000digitFibonacciNumber {

	public static void main(String[] args) {
		int n = 2;
		BigInteger a = BigInteger.ONE, b = BigInteger.valueOf(2);
		while (String.valueOf(a).length() < 1000) {
			a = a.add(b);
			b = b.add(a);
			n += 2;
		}
		System.out.println(n);
	}

}

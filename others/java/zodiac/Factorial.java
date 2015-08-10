package com.yntravelsky.zodiac.lijiali;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Compute Factorial number by Recursion
 * 
 * @author ljl
 * @since 20140527
 */

public class Factorial {

	public static BigInteger Recursion(BigInteger n) {

		// if (n.equqls(BigInteger.valueOf(0)))
		if (n.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		else
			return n.multiply(Recursion(n.subtract(BigInteger.ONE)));
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input an integer: ");
		BigInteger n = input.nextBigInteger();
		long start = System.currentTimeMillis();
		BigInteger result = Recursion(n);
		long end = System.currentTimeMillis();
		System.out.println("The Factorial of " + n + " is " + result);
		System.out.printf("The elapsed time is %d ms", end - start);
		input.close();

	}
}
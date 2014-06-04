package com.yntravelsky.zodiac.lijiali;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Compute Fibonacci number using temporary variables
 * 
 * @author ljl
 * @since 20140603
 */

public class Fibonacci2 {

	public static BigInteger f(int n) {
		BigInteger a = BigInteger.ZERO, b = BigInteger.ONE;
			for (int i = 1; i <= n / 2; i++) {
				a = a.add(b);
				b = b.add(a);
			}
			if (n % 2 == 0)
				return a;
			else
				return b;
	}

	/*
	 * 
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input an integer: ");
		int n = input.nextInt();
		long start = System.currentTimeMillis();
		BigInteger result = f(n);
		long end = System.currentTimeMillis();
		System.out.println("Fibonacci(" + n + ") = " + result);
		System.out.printf("The elapsed time is %d ms", end - start);
		input.close();
	}
}
package com.yntravelsky.zodiac.lijiali;

import java.util.Scanner;

/**
 * Compute Fibonacci number by Recursion
 * 
 * @author ljl
 * @since 20140528
 */

public class FibonacciRecursion {

	private static int compute(int small) {
		final int[] results = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };
		return results[small];
	}

	public static long Recursion(int n) {
		if (n <= 10) {
			return (long) compute(n);
		} else
			return Recursion(n - 1) + Recursion(n - 2);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input an integer: ");
		int n = input.nextInt();
		long start = System.currentTimeMillis();
		long result = Recursion(n);
		long end = System.currentTimeMillis();
		System.out.println("Fibonacci(" + n + ") = " + result);
		System.out.printf("The elapsed time is %d ms", end - start);
		input.close();
	}
}
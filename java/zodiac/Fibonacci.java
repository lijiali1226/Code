package com.yntravelsky.zodiac.lijiali;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Compute Fibonacci number using array
 * 
 * @author ljl
 * @since 20140529
 */

public class Fibonacci {

	public static BigInteger f(int n) {
		BigInteger result[] = new BigInteger[n + 1];
		result[0] = BigInteger.ZERO;
		if (n >= 1)
			result[1] = BigInteger.ONE;
		if (n >= 2) {
			for (int i = 2; i <= n; i++) {
				result[i] = result[i - 1].add(result[i - 2]);
			}
		}
		return result[n];
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
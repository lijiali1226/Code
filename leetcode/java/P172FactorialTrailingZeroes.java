package leetcode;

import java.math.BigInteger;

public class P172FactorialTrailingZeroes {

	// too slow
	public static int trailingZeroes(int n) {
		String s = countFactorial(n).toString();
		System.out.println(s);
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '0')
				count++;
			else
				break;
		}
		return count;

	}

	public static BigInteger countFactorial(int n) {
		if (n == 0)
			return BigInteger.ONE;
		return BigInteger.valueOf(n).multiply(countFactorial(n - 1));
	}

	// too slow
	public static int trailingZeroes2(int n) {
		int a = 0;
		for (int i = 1; i <= n; i++) {
			int temp = i;
			while (temp % 5 == 0) {
				temp /= 5;
				a++;
			}
		}
		return a;
	}

	public static int trailingZeroes3(int n) {
		int a = 0;
		for (int i = 1; n >= (Math.pow(5, i)); i++) {
			a += n / Math.pow(5, i);
		}
		return a;
	}

	public static int trailingZeroes4(int n) {
		int a = 0;
		for (long k = 5; n >= k ; k *= 5) {
			a += n / k;
		}
		return a;
	}

	public static void main(String[] args) {
		// System.out.println(trailingZeroes4(2147483647));
		System.out.println(trailingZeroes3(2147483647));
		System.out.println(trailingZeroes3(5));
		System.out.println(trailingZeroes4(2147483647));
		System.out.println(trailingZeroes4(5));
	}
}

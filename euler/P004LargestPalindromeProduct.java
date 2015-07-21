package euler;

public class P004LargestPalindromeProduct {

	public static boolean isPalindrome(int x) {
		int n = 0, i = 0;
		int number[] = new int[10];

		for (n = 0; x >= 10; n++) {
			number[n] = x % 10;
			x /= 10;
			// System.out.println("number[ " + n + " ] " + number[n]);
		}
		number[n] = x;

		for (i = 0; i <= n / 2; i++) {
			if (number[i] != number[n - i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		int a = 0, b = 0, product = 0, result = 0;
		for (a = 100; a <= 999; a++) {
			for (b = 100; b <= 999; b++) {
				product = a * b;
				if (isPalindrome(product) && product > result)
					result = product;
			}
		}
		System.out.println(result);
	}
}

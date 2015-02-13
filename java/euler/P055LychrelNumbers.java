package euler;

import java.math.BigInteger;

public class P055LychrelNumbers {

	public static boolean isNotLychrel(int n) {
		int count = 0;
		BigInteger temp = BigInteger.valueOf(n);
		for (count = 0; count < 50; count++) {
			temp = temp.add(reverse(temp));
			if (isPalindrome(temp)) {
				// System.out.println(n + " " + count + " " + temp);
				return true;
			}
		}
		return false;
	}

	private static boolean isPalindrome(BigInteger n) {
		String temp = n.toString();
		if (temp.length() == 1)
			return false;
		int i = 0;
		for (i = 0; i < temp.length() / 2; i++) {
			if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static BigInteger reverse(BigInteger n) {
		String temp = n.toString();
		String s = "";
		int i = 0;
		for (i = temp.length() - 1; i >= 0; i--) {
			s += temp.charAt(i);
		}
		return new BigInteger(s);
	}

	public static void main(String[] args) {
		int i = 0, count = 0;
		for (i = 1; i < 10_000; i++) {
			if (!isNotLychrel(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

}

package leetcode;

public class P009PalindromeNumber {

	public static boolean isPalindrome(int x) {

		String s = Integer.toString(x);
		for (int i = 0; i <= s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(12354436));
		System.out.println(isPalindrome(1));
		System.out.println(isPalindrome(123321));
		System.out.println(isPalindrome(456585654));
		// expected false true true true

	}

}

package leetcode;

public class P125ValidPlindrome {
	public static boolean isPalindrome(String s) {
		if (s.length() <= 1)
			return true;
		s = s.toLowerCase();
		StringBuffer s1 = new StringBuffer();
		int n = s.length() - 1;
		for (int i = 0; i <= n; i++) {
			char a = s.charAt(i);
			if ((a >= '0' && a <= '9') || (a >= 'a' && a <= 'z')) {
				s1.append(a);
			}
		}
		n = s1.length() - 1;
		for (int i = 0; i <= n; i++) {
			if (s1.charAt(i) != s1.charAt(n - i))
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		System.out.println(isPalindrome("12354436"));
		System.out.println(isPalindrome("1"));
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome(",&* a *()()()"));
		//expected  false true true true false true
	}
}

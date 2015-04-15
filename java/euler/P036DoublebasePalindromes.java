package euler;

public class P036DoublebasePalindromes {

	public static boolean isPalindrome(String s) {
		int i = 0, n = s.length() - 1;
		for (i = 0; i <= n / 2; i++) {
			if (s.charAt(i) != s.charAt(n - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int i = 0, sum = 0;
		String s1 = "", s2 = "";
		for (i = 0; i < 1_000_000; i++) {
			s1 = Integer.toString(i);
			s2 = Integer.toBinaryString(i);
			if (isPalindrome(s1) && isPalindrome(s2)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}

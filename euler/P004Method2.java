package euler;

public class P004Method2 {

	private static boolean isPlalindrome(String s) {
		for (int i = 0, n = s.length(); i < n; i++) {
			if (s.charAt(i) != s.charAt(n - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int top = 999;
		int answer = 0;
		for (int i = 0, imax = top; i < imax; i++) {
			for (int j = 0, jmax = top; j < jmax; j++) {
				if (i * j > answer && isPlalindrome(String.valueOf(i * j))) {
					answer = i * j;
				}
			}
		}
		System.out.println(answer);
	}
}

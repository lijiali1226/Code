package leetcode;

public class P171ExcelSheetColumnNumber {

	public static int titleToNumber(String s) {
		int i, n = 0;

		for (i = 0; i <= s.length() - 1; i++) {
			n += (s.charAt(i) - 'A' + 1) * (int) Math.pow(26, s.length() - i - 1);
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("BZ"));
		// expected 1 28 78
	}

}

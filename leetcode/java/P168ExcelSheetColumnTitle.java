package leetcode;

import java.util.ArrayList;

public class P168ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		int i = n;
		ArrayList<Character> arrlist = new ArrayList<Character>();

		for (i = n; i > 0; i /= 26) {
			if (i % 26 == 0) {
				arrlist.add('Z');
				i -= 26;
			} else {
				arrlist.add((char) (i % 26 - 1 + 'A'));
				i -= i % 26;
			}
		}
		String s = "";
		for (i = arrlist.size() - 1; i >= 0; i--) {
			s += arrlist.get(i);
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle(78));
		System.out.println(convertToTitle(1));
		System.out.println(convertToTitle(702));
		// expected BZ A ZZ
	}

}

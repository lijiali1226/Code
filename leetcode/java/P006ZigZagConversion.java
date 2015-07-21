package leetcode;

public class P006ZigZagConversion {
	public static String convert(String s, int numRows) {
		char[][] matrix = new char[s.length()][numRows];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length() && i < s.length(); j++) {
				for (int k = 0; k < numRows && i < s.length(); k++) {
					matrix[j][k] = s.charAt(i);
					i++;
				}
				for (int m = numRows - 2; m >= 1 && i < s.length(); m--) {
					matrix[j + 1][m] = s.charAt(i);
					i++;
					j++;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int k = 0; k < numRows; k++) {
			for (int j = 0; j < s.length(); j++) {
				if (matrix[j][k] != '\0')
					sb.append(matrix[j][k]);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPA", 3));
		System.out.println(convert("PAYPALISHIRING", 5));
		// expected PAHNAPLSIIGYIR PAAPY RHASIYIRPLIGAN
	}

}

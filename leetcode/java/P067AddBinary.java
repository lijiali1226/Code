package leetcode;

public class P067AddBinary {

	// Exception
	public static String addBinary(String a, String b) {
		int x = Integer.parseInt(a, 2);
		int y = Integer.parseInt(b, 2);
		String s = Integer.toBinaryString(x + y);
		return s;

	}

	private static String addBinary2(String a, String b) {

		StringBuffer s = new StringBuffer();
		int flag = 0, temp = 0;
		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0;) {
			if (i >= 0 && j >= 0) {
				temp = a.charAt(i--) + b.charAt(j--) - '0' - '0' + flag;
			} else if (i >= 0) {
				temp = a.charAt(i--) - '0' + flag;
			} else if (j >= 0) {
				temp = b.charAt(j--) - '0' + flag;
			}
			flag = 0;
			if (temp >= 2) {
				flag = 1;
				temp -= 2;
			}
			s.append(temp);
		}
		if (flag == 1)
			s.append(flag);
		return s.reverse().toString();
	}

	public static void main(String[] args) {

		System.out.println(addBinary2("11", "1"));
		System.out.println(addBinary2("11", "0"));
		// expected 100 11
		System.out
				.println(addBinary2(
						"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
						"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
		System.out.println(addBinary2("1010", "1011"));
		// expected 10101
	}

}

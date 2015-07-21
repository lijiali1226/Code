package leetcode;

public class P008StringToIntegerAtoi {
	private static final long INT_MAX = 2147483647;
	private static final long INT_MIN = -2147483648;

	public static int atoi(String str) {

		if (str.length() == 0)
			return 0;

		boolean flag = false;
		long x = 0, count = 0;

		while (str.charAt(0) == ' ') {
			str = str.substring(1);
		}

		if (str.charAt(0) == '-') {
			flag = true;
			str = str.substring(1);
		} else if (str.charAt(0) == '+') {
			str = str.substring(1);
		}

		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				x += (str.charAt(i) - '0') * Math.pow(10, count);
				count++;
			} else {
				if (count != 0) {
					x = 0;
					count = 0;
				}
			}
		}

		if (flag == true)
			x = -x;
		if (x > INT_MAX)
			x = INT_MAX;
		else if (x < INT_MIN)
			x = INT_MIN;
		return (int) x;
	}

	public static void main(String[] args) {
		System.out.println(atoi("1234"));// 1234
		System.out.println(atoi("-1234"));// -1234
		System.out.println(atoi("    456ab"));// 456
		System.out.println(atoi(""));// 0
		System.out.println(atoi("abcd"));// 0
		System.out.println(atoi("2147483648"));// 2147483647
		System.out.println(atoi("-12344567890"));// -2147483648
		System.out.println(atoi("+-2"));// 0
		System.out.println(atoi("+2"));// 2
		System.out.println(atoi("  -0012a42"));// -12
		System.out.println(atoi("   +0 123"));// 0
		System.out.println(atoi("-2147483648"));// -2147483648
	}

}

package leetcode;

public class P007ReverseInteger {

	public static int reverse(int x) {
		boolean flag = false;
		int i = 0;
		if (x < 0) {
			flag = true;
			x = -x;
		}
		char[] s = String.valueOf(x).toCharArray();
		for (i = 0; i < s.length / 2; i++) {
			char temp;
			temp = s[i];
			s[i] = s[s.length - 1 - i];
			s[s.length - 1 - i] = temp;
		}
		if (s.length > 10)
			return 0;
		String s1 = "2147483647";
		if (s.length == 10) {
			for (i = 0; i < 10; i++) {
				if (s[i] < s1.charAt(i))
					break;
				if (s[i] > s1.charAt(i))
					return 0;
			}
		}
		x = Integer.parseInt(String.copyValueOf(s));
		if (flag == true)
			x = -x;
		return x;

	}

	public static void main(String[] args) {
		// System.out.println(Integer.MAX_VALUE);
		// System.out.println(Integer.MIN_VALUE);
		// System.out.println(reverse(123));
		// System.out.println(reverse(-123));
		// System.out.println(reverse(1000000003));
		// System.out.println(reverse(10));
		System.out.println(reverse(-2147483412));
		// System.out.println(reverse(900000));
	}
}

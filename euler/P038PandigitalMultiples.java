package euler;

public class P038PandigitalMultiples {

	public static boolean isPandigital(String temp) {
		int i = 0, j = 0;
		if (temp.length() != 9)
			return false;
		for (i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == '0')
				return false;
			for (j = i + 1; j < temp.length(); j++) {
				if (temp.charAt(i) == temp.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int i = 0, j = 0, max = 0;
		String s = "";
		for (i = 1; i < 10_000; i++) {
			for (j = 1, s = ""; j < 9 && s.length() <= 9; j++) {
				if (s.length() == 9) {
					if (isPandigital(s) && max < Integer.parseInt(s)) {
						max = Integer.parseInt(s);
						// System.out.println(max);
					}
				}
				s += j * i;
			}
		}
		System.out.println(max);

	}

}

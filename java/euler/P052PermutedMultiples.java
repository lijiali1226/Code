package euler;

public class P052PermutedMultiples {

	public static boolean hasSameDigits(int a, int b) {
		String sa = Integer.toString(a), sb = Integer.toString(b);
		if (sa.length() != sb.length())
			return false;
		int i = 0;
		for (i = 0; i < sa.length(); i++) {
			if (!sb.contains(sa.subSequence(i, i + 1))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int i = 0;
		for (i = 1; i < 1_000_000; i++) {
			if (hasSameDigits(i, 6 * i) && hasSameDigits(i, 5 * i) && hasSameDigits(i, 4 * i)
					&& hasSameDigits(i, 3 * i) && hasSameDigits(i, 2 * i)) {
				System.out.println(i);
				break;
			}
		}
	}
}

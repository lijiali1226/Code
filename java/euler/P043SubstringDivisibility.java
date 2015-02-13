package euler;

public class P043SubstringDivisibility {

	// ***************************** too slow *****************************************************
	public static boolean isPandigital(Long n) {
		String temp = n.toString();

		int i = 0, j = 0;
		for (i = 0; i < temp.length(); i++) {
			for (j = i + 1; j < temp.length(); j++) {
				if (temp.charAt(i) == temp.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean hasProperty(long num) {
		String s = Long.toString(num);
		int j = 0;
		int[] n = { 2, 3, 5, 7, 11, 13, 17 };
		for (j = 1; j <= 7; j++) {
			if (Integer.parseInt(s.substring(j, j + 3)) % n[j - 1] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		long i = 0L, sum = 0;
		for (i = 1023456789L; i < 10_000_000_000L; i++) {
			if (isPandigital(i) && hasProperty(i)) {
				System.out.println(i);
				sum += i;
			}
		}
		System.out.println(sum);
	}
}

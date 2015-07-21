package euler;

public class P041PandigitalPrime {
	public static boolean isPrime(int n) {
		int i = 0;
		for (i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPandigital(int n) {
		int i = 0, j = 0;
		String temp = Integer.toString(n);
		for (i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) > temp.length() + '0' || temp.charAt(i) == '0')
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
		int i = 0, max = 0;
		for (i = 11; i < 7654321; i++) {
			// Nine numbers cannot be done (1+2+3+4+5+6+7+8+9=45 => always dividable by 3)
			// Eight numbers cannot be done (1+2+3+4+5+6+7+8=36 => always dividable by 3)
			if (isPrime(i) && isPandigital(i)) {
				if (max < i) {
					max = i;
					// System.out.println(max);
				}
			}
		}
		System.out.println(max);
	}
}

package euler;

public class P092SquareDigitChains {

	public static boolean isChain(int n) {

		int sum = 0;
		while (true) {
			if (n == 89)
				return true;
			if (n == 1)
				return false;
			sum = 0;
			for (; n > 0; n /= 10) {
				sum += (n % 10) * (n % 10);
			}
			n = sum;
		}
	}

	public static void main(String[] args) {
		int i = 0, count = 0;
		for (i = 1; i < 10_000_000; i++) {
			if (isChain(i))
				count++;
		}
		System.out.println(count);
	}
}

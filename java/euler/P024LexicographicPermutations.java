package euler;

public class P024LexicographicPermutations {

	public static int factorial(int n) {
		int i = 0, product = 1;
		for (i = 1; i <= n; i++) {
			product *= i;
		}
		// System.out.println(product);
		return product;
	}

	public static void main(String[] args) {
		int i, n = 1_000_000;
		String s = "";
		for (i = 10; i > 1; i--) {
			s = s + n / factorial(i - 1);
			n %= factorial(i - 1);
			System.out.println(" s " + s + " n " + n);
		}
		System.out.println(s);
	}

}

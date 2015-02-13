package euler;

public class P028NumberSpiralDiagonals {

	public static void main(String[] args) {
		final int N = 1001;
		int i = 1, j = 0, k = 0, sum = 1;

		for (j = 1; j <= N / 2; j++) {
			for (k = 0; k < 4; k++) {
				i += 2 * j;
				sum += i;
			}
		}

		System.out.println(sum);
	}

}

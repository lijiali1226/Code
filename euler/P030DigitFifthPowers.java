package euler;

public class P030DigitFifthPowers {

	public static void main(String[] args) {
		int i = 0, j = 0, sum = 0, temp = 0;
		final int N = 5;

		for (i = 10; i < 1_000_000; i++) {
			temp = 0;
			for (j = i; j / 10 > 0; j /= 10) {
				// System.out.println(Math.pow(j % 10, 4));
				temp += Math.pow(j % 10, N);
				// System.out.println(temp);
			}
			temp += Math.pow(j, N);

			if ((int) temp == i) {
				sum += i;
				System.out.println(sum + " " + i);
			}
		}
		System.out.println(sum);
	}

}

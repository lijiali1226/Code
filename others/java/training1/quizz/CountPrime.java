package quizz;

public class CountPrime {

	public static void main(String[] args) {
		int i = 0, j = 0, n = 0;
		out: for (i = 2; i <= 100; i++) {
			for (j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					continue out;
				}
			}
			System.out.print(i + "\t");
			n++;
			if (n % 10 == 0)
				System.out.println();
		}

	}
}

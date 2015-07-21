package quizz;

public class PrintStars {

	public static void main(String[] args) {
		int i = 0, j = 0, k = 0, N = 3;
		for (i = 0; i <= N; i++) {
			for (j = 0; j < N - i; j++) {
				System.out.print(" ");
			}
			for (k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}

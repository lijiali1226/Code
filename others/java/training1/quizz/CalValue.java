package quizz;

public class CalValue {

	public static void main(String[] args) {
		double i = 0, sum = 0;
		for (i = 1; i <= 10; i++) {
			sum += 1.0 / i;
		}
		System.out.printf("%.2f", sum);
	}

}

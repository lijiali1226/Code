package ch1to5;

public class MonterCarloSimulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NUMBER_OF_TRAILS = 10000000;
		int numberOfHits = 0;

		for (int i = 0; i < NUMBER_OF_TRAILS; i++) {
			double x = Math.random() * 2.0 - 1;
			double y = Math.random() * 2.0 - 1;
			if (x * x + y * y <= 1)
				numberOfHits++;
		}

		double pi = 4.0 * numberOfHits / NUMBER_OF_TRAILS;
		System.out.println("PI is " + pi);
	}

}

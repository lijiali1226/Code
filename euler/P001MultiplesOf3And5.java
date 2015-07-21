package euler;

public class P001MultiplesOf3And5 {

	public static void main(String args[]) {
		int i;
		int sum = 0;
		for (i = 0; i < 1000; i++) {
			if ((i % 3 == 0) || (i % 5 == 0)) {
				sum += i;
				// System.out.println(" i " + i + " sum " + sum);
			}
		}
		System.out.println(sum);
	}
}

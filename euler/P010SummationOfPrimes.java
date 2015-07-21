package euler;

public class P010SummationOfPrimes {

	public static void main(String args[]) {
		int i = 0, j = 0, flag = 0;
		long sum = 0L;
		for (i = 2; i < 2_000_000; i++) {
			flag = 0;
			for (j = 2; j * j <= i; j++) {// pay attention j * j <= i
				if (i % j == 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				sum += i;
				// System.out.println(" sum " + sum + " i " + i);
			}
		}
		System.out.println(sum);
	}
}

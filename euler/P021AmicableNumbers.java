package euler;

public class P021AmicableNumbers {

	public static int getPrimeSum(int n) {
		int i = 0, sum = 0;
		for (i = 1; i < n; i++) {
			if (n % i == 0)
				sum += i;
		}
		// System.out.println(sum);
		return sum;
	}

	public static void main(String[] args) {
		int i = 0, temp = 0, sum = 0;
		final int N = 10000;
		for (i = 1; i < N; i++) {
			temp = getPrimeSum(i);
			if (i != temp && i == getPrimeSum(temp))
				sum += i;
			System.out.println("i " + i + " temp " + temp + " sum " + sum);
		}
		System.out.println(sum);
	}

}

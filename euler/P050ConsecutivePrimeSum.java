package euler;

import java.util.ArrayList;

public class P050ConsecutivePrimeSum {

	public static boolean isPrime(int n) {
		int i = 0;
		for (i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int i = 0, j = 0;
		int N = 1_000_00;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (i = 2; i < N; i++) {
			if (isPrime(i)) {
				list.add(i);
			}
		}
		int sum = 0, count = 0, max = 0, result = 0;
		for (i = 0; i < list.size(); i++) {
			for (j = i, sum = 0, count = 0; j < list.size() && sum < 1_000_000; j++) {
				sum += list.get(j);
				count++;
				if (isPrime(sum) && max < count) {
					max = count;
					result = sum;
				}
			}
		}
		System.out.println(result);
	}
}

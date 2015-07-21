package leetcode;

public class P204CountPrimes {

	// too slow
	public static int countPrimes(int n) {
		int count = 0;
		out: for (int i = 2; i < n; i++) {
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0)
					continue out;
			}
			count++;
		}
		return count;
	}

	public static int countPrimes2(int n) {
		boolean[] array = new boolean[n];
		for (int i = 2; i < n; i++) {
			array[i] = true;
		}
		for (int i = 2; i < n; i++) {
			if (array[i] == false)
				continue;
			for (int j = 2; j * i < n; j++) {
				array[j * i] = false;
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (array[i] == true)
				count++;
		}

		return count;

	}

	public static void main(String[] args) {
		System.out.println(countPrimes2(1));
		System.out.println(countPrimes2(2));
		System.out.println(countPrimes2(3));
		System.out.println(countPrimes2(4));
		System.out.println(countPrimes2(10));
		System.out.println(countPrimes2(100));
		System.out.println(countPrimes2(1500000));
		// expected 0 0 1 2 4

	}

}

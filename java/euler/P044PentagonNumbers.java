package euler;

import java.util.Arrays;

public class P044PentagonNumbers {

	public static boolean isPentagonal(int pentagonal[], int value) {
		if (Arrays.binarySearch(pentagonal, value) >= 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int i = 0, j = 0, temp = 0, N = 5000;
		int[] list = new int[N];
		for (i = 1; i < N; i++) {
			list[i - 1] = i * (3 * i - 1) / 2;
		}
		out: for (i = 1; i < N; i++) {
			for (j = 0; j < i; j++) {
				temp = Math.abs(list[i] - list[j]);
				if (isPentagonal(list, temp) && isPentagonal(list, list[i] + list[j])) {
					System.out.println(temp + " " + i + " " + j);
					break out;
				}
			}
		}
	}
}

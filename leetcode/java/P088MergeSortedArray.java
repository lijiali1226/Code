package leetcode;

import java.util.Arrays;

public class P088MergeSortedArray {

	public static void merge(int A[], int m, int B[], int n) {
		int i = 0;
		int[] C = new int[m + n];
		for (i = 0; i < m; i++) {
			C[i] = A[i];
		}
		for (i = m; i < m + n; i++) {
			C[i] = B[i - m];
		}
		Arrays.sort(C);
		for (i = 0; i < m + n; i++) {
			System.out.print(C[i]);
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		int[] B = { 5, 4, 3 };
		merge(A, 5, B, 3);

	}

}

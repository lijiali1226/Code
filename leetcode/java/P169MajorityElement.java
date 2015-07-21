package leetcode;

import java.util.Arrays;

public class P169MajorityElement {
	// too slow
	public static int majorityElement2(int[] num) {
		int n = num.length, i, j, e, count = 0;
		for (i = 0; i < n; i++) {
			e = num[i];
			count = 0;
			for (j = i; j < n; j++) {
				if (num[j] == e) {
					count++;
				}
				if (count > n / 2)
					return e;
			}
		}
		return 0;
	}

	public static int majorityElement(int[] num) {
		Arrays.sort(num);
		return num[num.length / 2];
	}

	public static void main(String[] args) {
		int[] a = { 7, 7, 8, 8, 8 };
		System.out.println(majorityElement(a));
		System.out.println(majorityElement2(a));
	}

}

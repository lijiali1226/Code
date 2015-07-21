package leetcode;

import java.util.Arrays;

public class P066PlusOne {

	public static int[] plusOne(int[] digits) {
		int inc = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			int temp = digits[i] + inc;
			inc = 0;
			if (i == digits.length - 1)
				temp += 1;
			if (temp >= 10) {
				digits[i] = temp - 10;
				inc = 1;
			} else
				digits[i] = temp;
		}
		if (inc == 1) {
			int[] ret = new int[digits.length + 1];
			int k = 1;
			for (int i : digits) {
				ret[k++] = i;
			}
			ret[0] = 1;
			return ret;
		}
		return digits;

	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 7 };
		int[] b = { 9, 9, 9, 9 };
		int[] c = {};
		System.out.println(Arrays.toString(plusOne(a)));
		System.out.println(Arrays.toString(plusOne(b)));
		System.out.println(Arrays.toString(plusOne(c)));

	}

}

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class P217ContainsDuplicate {
	// too slow
	public static boolean containsDuplicate2(int[] nums) {
		if (nums.length <= 1)
			return false;
		for (int i = 0; i < nums.length; i++) {
			int temp = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == temp)
					return true;
			}
		}
		return false;
	}

	public static boolean containsDuplicate3(int[] nums) {
		if (nums.length <= 1)
			return false;
		Set<Integer> a = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			a.add(nums[i]);
		}
		if (a.size() != nums.length)
			return true;
		return false;
	}

	public static boolean containsDuplicate(int[] nums) {
		if (nums.length <= 1)
			return false;
		int max = 0, min = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
		}
		boolean[] a = new boolean[max-min + 1];
		for (int i = 0; i < nums.length; i++) {
			a[nums[i]-min] = true;
		}
		int count = 0;
		for (int i = 0; i <= max-min; i++) {
			if (a[i] == true)
				count++;
		}
		if (count < nums.length)
			return true;
		return false;
	}

	public static void main(String args[]) {
		int[] a = { 1, 2, 3, 4, 4, 6 };
		int[] b = { 2, 2, 5, 6, 6, 9 };
		int[] c = { 3, 3, 4, 4, 5, 5, 8 };
		int[] d = { 4, 5 };
		int[] e = {};
		int[] f = { 1 };
		int[] g = { 1, 1, 2, 2 };
		int[] h = { 1, 5, -2, -4, 0 };

		System.out.println(containsDuplicate(a));
		System.out.println(containsDuplicate(b));
		System.out.println(containsDuplicate(c));
		System.out.println(containsDuplicate(d));
		System.out.println(containsDuplicate(e));
		System.out.println(containsDuplicate(f));
		System.out.println(containsDuplicate(g));
		System.out.println(containsDuplicate(h));
		// expected true true true false false false true false
	}

}

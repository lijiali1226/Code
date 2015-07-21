package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class P219ContainsDuplicateII {
	// too slow
	public static boolean containsNearbyDuplicate3(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] == nums[j]) && (j - i <= k)) {
					return true;
				}
			}
		}

		return false;
	}

	// slower
	public static boolean containsNearbyDuplicate2(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; (j - i <= k) && (j < nums.length); j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}

		return false;

	}

	// OK
	public static boolean containsNearbyDuplicate4(int[] nums, int k) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer j = m.put(nums[i], i);
			if (j != null && (i - j <= k)) {
				return true;
			}
		}

		return false;

	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> m = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k)
				m.remove(nums[i - k - 1]);
			if (!m.add(nums[i]))
				return true;
		}
		return false;

	}

	public static void main(String args[]) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 1 };
		int[] c = {};
		int[] d = { 1 };
		int[] e = { 1, 2, 3, 1 };
		int[] f = new int[29999];
		for (int i = 0; i < 29999; i++) {
			f[i] = i;
		}
		long time1 = System.currentTimeMillis();
		System.out.println(containsNearbyDuplicate(a, 1));
		System.out.println(containsNearbyDuplicate(b, 1));
		System.out.println(containsNearbyDuplicate(b, 10));
		System.out.println(containsNearbyDuplicate(c, 10));
		System.out.println(containsNearbyDuplicate(d, 10));
		System.out.println(containsNearbyDuplicate(e, 2));
		System.out.println(containsNearbyDuplicate(e, 3));
		System.out.println(containsNearbyDuplicate(f, 29999));
		long time2 = System.currentTimeMillis();
		// expected f f t f f f t f
		System.out.println(time2 - time1);
	}

}

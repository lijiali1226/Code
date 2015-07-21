package leetcode;

public class P026RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		int n = 0;
		if (nums.length <= 1)
			return nums.length;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[n++] = nums[i];
			}
		}
		nums[n++] = nums[nums.length - 1];
		return n;

	}

	public static void main(String args[]) {
		int[] a = { 1, 2, 3, 4, 4, 6 };
		int[] b = { 2, 2, 5, 6, 6, 9 };
		int[] c = { 3, 3, 4, 4, 5, 5, 8 };
		int[] d = { 4, 5 };
		int[] e = {};
		int[] f = { 1 };
		int[] g = { 1, 1, 2, 2 };
		System.out.println(removeDuplicates(a));
		System.out.println(removeDuplicates(b));
		System.out.println(removeDuplicates(c));
		System.out.println(removeDuplicates(d));
		System.out.println(removeDuplicates(e));
		System.out.println(removeDuplicates(f));
		System.out.println(removeDuplicates(g));
		// expected 5 4 4 2 0 1 2
	}
}

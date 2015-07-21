package leetcode;

public class P027RemoveElement {
	public static int removeElement(int[] nums, int val) {
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[n++]=nums[i];
			}
		}
		return n;

	}

	public static void main(String args[]) {
		int[] a = { 1, 2, 3, 4, 4, 6 };
		int[] b = { 46, 75, 73, 5, 4, 8, 2, 2 };
		int[] c = { 3, 4, 7, 8, 4, 6, 7, 3, 5, 56, 6, 3, 3 };
		int[] d = { 4, 5 };
		int[] e={};
		System.out.println(removeElement(a, 1));
		System.out.println(removeElement(a, 4));
		System.out.println(removeElement(b, 1));
		System.out.println(removeElement(b, 2));
		System.out.println(removeElement(c, 3));
		System.out.println(removeElement(d, 4));
		System.out.println(removeElement(e, 4));
		// expected 5 4 8 6 9
	}
}

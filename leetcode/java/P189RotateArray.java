package leetcode;

public class P189RotateArray {

	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[(k + i) % n] = nums[i];
		}
		for (int i = 0; i < n; i++) {
			nums[i] = a[i];
		}
	}

	public static void rotate2(int[] nums, int k) {
		int n = nums.length;
		int[] a = new int[n];
		int j = 0;
		for (int i = n - k%n; i < n; i++) {
			a[j++] = nums[i];
		}
		for (int i = 0; i < n - k%n; i++) {
			a[j++] = nums[i];
		}
		for (int i = 0; i < n && n > 1; i++) {
			nums[i] = a[i];
		}
	}

	public static void main(String[] args) {
		int[] b = { -1 };
		rotate2(b, 2);
		int[] a = { 1, 2,3 };
		rotate2(a, 4);
		int[] c = { 1,2 };
		rotate2(c, 3);
		for (int i = 0; i < b.length; i++)
			System.out.println(b[i]);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
		for (int i = 0; i < c.length; i++)
			System.out.println(c[i]);
	}
}

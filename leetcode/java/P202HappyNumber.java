package leetcode;

public class P202HappyNumber {
	public static boolean isHappy(int n) {
		int sum = 0, a = 0, count = 0;
		while (n != 1) {
			sum = 0;
			while (n / 10 > 0) {
				a = n % 10;
				n /= 10;
				sum += a * a;
			}
			sum += n * n;
			n = sum;
			count++;
			if (count > 100_000)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(7));

	}

}

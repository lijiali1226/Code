package leetcode;

public class P191NumberOf1Bits {
	public static int hammingWeight(int n) {
		String s = Integer.toBinaryString(n);
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(hammingWeight(11));
	}

}

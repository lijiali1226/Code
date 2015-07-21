package leetcode;

public class P190ReverseBits {
	public static int reverseBits(int n) {
		String s = Integer.toBinaryString(n);
		System.out.println(s);
		String temp = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			temp += s.charAt(i);
		}
		for (int i = 0; i < 32 - s.length(); i++) {
			temp += "0";
		}
		System.out.println(temp);
		n = Integer.parseUnsignedInt(temp, 2);
		return n;

	}

	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));

	}

}

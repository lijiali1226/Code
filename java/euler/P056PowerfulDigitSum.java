package euler;

import java.math.BigInteger;

public class P056PowerfulDigitSum {

	public static int countDigitSum(int a, int b) {
		BigInteger n = BigInteger.valueOf(a).pow(b);
		String s = n.toString();
		//System.out.println(s);
		int i = 0, sum = 0;
		for (i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - '0';
		}
		//System.out.println(sum);
		return sum;
	}

	public static void main(String[] args) {
		int a = 0, b = 0, temp = 0, max = 0;
		for (a = 2; a < 100; a++) {
			for (b = 1; b < 100; b++) {
				temp = countDigitSum(a, b);
				if (max < temp) {
					max = temp;
				}
			}
		}
		System.out.println(max);
	}

}

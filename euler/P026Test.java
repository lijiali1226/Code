package euler;

import java.math.BigDecimal;

public class P026Test {
	public static boolean isNonterminating(int a, int b) {
		try {
			BigDecimal bigA = new BigDecimal(a);
			BigDecimal bigB = new BigDecimal(b);
			System.out.println("a/b=" + bigA.divide(bigB));
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static void main(String args[]) {
		System.out.println(isNonterminating(1, 2));
	}
}

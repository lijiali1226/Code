package euler;

import java.math.BigInteger;

public class P016PowerDigitSum {

	public static void main(String[] args) {
		BigInteger power = BigInteger.ONE;
		BigInteger factor = BigInteger.valueOf(2);
		String string = "";
		int sum = 0, i = 0;

		for (i = 0; i < 1000; i++) {
			power = power.multiply(factor);
		}
		// System.out.println("power " + power);

		string = power.toString();
		System.out.println(string);

		for (i = 0; i < string.length(); i++) {
			sum += Integer.parseInt(string.substring(i, i + 1));
			// System.out.println(" sum " + sum);
		}
		System.out.println(sum);
	}

}

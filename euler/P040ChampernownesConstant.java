package euler;

public class P040ChampernownesConstant {

	public static void main(String[] args) {
		// **************** version 1 too slow*******************************************
		// int i = 0, product = 1;
		// String s = "0";
		// for (i = 1; s.length() <= 1_000_000; i++) {
		// s = s + i;
		// }
		// for (i = 1; i <= 1_000_000; i *= 10) {
		// product *= s.charAt(i) - '0';
		// }
		// System.out.println(product);
		// ****************************************************************************

		int i = 0, j = 0, count = 0, num = 0, product = 1;
		String temp = "";
		for (i = 1; count <= 1_000_000; i++) {
			temp = Integer.toString(i);
			for (j = 0; j < temp.length(); j++) {
				num = temp.charAt(j) - '0';
				count++;
				if (count == 1 || count == 10 || count == 100 || count == 1_000 || count == 10_000 || count == 100_000
						|| count == 1_000_000) {
					product *= num;
					System.out.println(" num " + num + " product " + product);
				}
			}
		}
		System.out.println(product);
	}

}

package euler;

public class P031CoinSums {

	public static void main(String[] args) {
		int a, b, c, d, e, f, g, count = 0;
		for (a = 0; a <= 2; a++) {
			for (b = 0; b <= 4; b++) {
				for (c = 0; c <= 10; c++) {
					for (d = 0; d <= 20; d++) {
						for (e = 0; e <= 40; e++) {
							for (f = 0; f <= 100; f++) {
								for (g = 0; g <= 200; g++) {
									if (g + 2 * f + 5 * e + 10 * d + 20 * c + 50 * b + 100 * a == 200) {
										count++;
										// System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " "
										// + g);
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}

package euler;

public class P009SpecialPythagoreanTriplet {

	public static void main(String args[]) {
		int a = 0, b = 0, c = 0;
		for (a = 1; a < 1000; a++) {
			for (b = a + 1; b < 1000; b++) {
				for (c = b + 1; c < 1000; c++) {
					if (a * a + b * b == c * c && a + b + c == 1000) {
						System.out.println(a * b * c);
					}
				}
			}
		}
	}

}

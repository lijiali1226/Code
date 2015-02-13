package euler;

public class P045TriangularPentagonalAndHexagonal {
	public static long calculate() {
		long i = 287, j = 166, k = 144;

		for (;; k++) {
			i = 2 * k - 1;
			for (; j * (3 * j - 1) <= i * (i + 1); j++) {
				if (j * (3 * j - 1) == i * (i + 1)) {
					System.out.println(" i " + i + " j " + j + " " + i * (i + 1) / 2);
					return i * (i + 1) / 2;
				}

			}
		}
	}

	public static void main(String[] args) {
		System.out.println(calculate());
	}
}

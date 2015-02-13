package euler;

public class P039IntegerRightTriangles {

	public static int countRightTriangle(int n) {
		int a, b, count = 0;
		for (a = 1; a < n / 2; a++) {
			for (b = 1; b < a; b++) {
				if (2 * a + 2 * b > n && a * a + b * b == (n - a - b) * (n - a - b)) {
					// System.out.println(" a " + a + " b " + b + " n " + n);
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 0, i = 12, n = 0;
		for (; i <= 1000; i++) {
			if (max < countRightTriangle(i)) {
				max = countRightTriangle(i);
				System.out.println("i " + i + " max " + max);
				n = i;
			}
		}
		System.out.println(n);
	}

}

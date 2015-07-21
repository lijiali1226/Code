package euler;

public class P006SumSquareDifference {

	public static int sumOfSquare(int n) {
		int i = 0, sum = 0;
		for (i = 1; i <= n; i++) {
			sum += i * i;
		}
		return sum;
	}

	public static int squareOfSum(int n) {
		int i = 0, sum = 0;
		for (i = 1; i <= n; i++) {
			sum += i;
		}
		return sum * sum;
	}

	public static void main(String args[]) {
		int a = 100, b = 100, result = 0;
		a = sumOfSquare(a);
		b = squareOfSum(b);
		if (a - b >= 0)
			result = a - b;
		else
			result = b - a;
		System.out.println(result);
	}
}

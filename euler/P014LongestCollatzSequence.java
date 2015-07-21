package euler;

public class P014LongestCollatzSequence {

	public static int getSequenceLength(long n) {
		int count = 0;
		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = 3 * n + 1;
			}
			// System.out.println(n);
			count++;
		}
		return count;
	}

	public static void main(String args[]) {
		int i = 0, temp = 0, result = 0;
		for (i = 2; i < 1_000_000; i++) {
			// System.out.println("i " + i + " length " + getSequenceLength(i));
			if (getSequenceLength(i) > temp) {
				temp = getSequenceLength(i);
				result = i;
				// System.out.println("result " + result + " temp " + temp);
			}
		}
		System.out.println(result);
	}
}

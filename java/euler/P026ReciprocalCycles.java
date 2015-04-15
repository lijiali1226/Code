package euler;

public class P026ReciprocalCycles {

	public static void main(String[] args) {
		int max = 0;
		for (int i = 2; i < 1000; i++) {
			if (i % 2 == 0 || i % 5 == 0)
				continue;
			int a = 10;
			int count = 1;
			while (a % i != 1) {
				a = a % i * 10;
				count++;
			}

			if (count > max) {
				max = count;
				System.out.println(max + " " + i + " " + 1 / (double) i);
			}
		}
	}

}

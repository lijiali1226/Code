package euler;

public class P005SmallestMultiple {

	public static void main(String args[]) {
		int i = 0, j = 0, flag = 0;

		for (i = 20; i < 1_000_000_000; i++) {
			flag = 0;
			for (j = 20; j > 0; j--) {
				if (i % j != 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println("result " + i);
				break;
			}

		}
	}
}

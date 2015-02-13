package euler;

import java.util.ArrayList;

public class P045Method1 {

	public static void main(String[] args) {
		ArrayList<Long> Triangle = new ArrayList<Long>();
		long i = 0, j = 0;
		for (i = 287; i < 100_000; i += 2) {
			Triangle.add(i * (i + 1));
		}
		for (j = 166; j < 100_000; j++) {
			if (Triangle.contains(j * (3 * j - 1))) {
				System.out.println(j * (3 * j - 1) / 2);
				break;
			}
		}
	}
}

package euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P047Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		int limit = 150_000;
		for (int i = 644 * 2; i < limit; i++) {
			Set<Integer> set = new HashSet<Integer>();
			int temp = i;
			for (int j = 2; j * j < temp; j++) {
				while (temp % j == 0) {
					set.add(j);
					temp /= j;
				}
			}
			if (temp != 1)
				set.add(temp);
			if (set.size() == 4) {
				list.add(i);
				// System.out.println(i);
				if (list.contains(i - 1) && list.contains(i - 2) && list.contains(i - 3))
					System.out.println(i);
			}
		}

	}

}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P119PascalsTriangleII {

	// too slow
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> l = Arrays.asList(1, 1);
		if (rowIndex == 1)
			return l;
		List<Integer> r = new ArrayList<Integer>(rowIndex + 1);
		r.add(1);
		for (int i = 1; i < rowIndex; i++) {
			r.add(getRow(rowIndex - 1).get(i) + getRow(rowIndex - 1).get(i - 1));
		}
		r.add(1);
		return r;

	}

	public static List<Integer> getRow2(int rowIndex) {
		List<Integer> r = new ArrayList<Integer>(rowIndex + 1);
		int k = (rowIndex + 1) % 2 == 0 ? (rowIndex + 1) / 2
				: (rowIndex + 1) / 2 + 1;
		for (int i = 0; i < k; i++) {
			if (i == 0)
				r.add(1);
			if (i == 1)
				r.add(rowIndex);
			if (i > 1) {
				double cn = 1;
				for (int m = 1; m <= i; m++) {
					cn *= (rowIndex - i + m) / (double) m;
				}
				cn=Math.round(cn);
				r.add(i,(int) cn);
			}
		}
		for (int i = k; i < rowIndex + 1; i++) {
			r.add(i, r.get(rowIndex - i));
		}
		return r;

	}

	public static void main(String[] args) {
		// for (int i = 1; i <= 10; i++) {
		// System.out.println(i + " " + getRow(i));
		// System.out.println(i + " " + getRow2(i));
		// }
		// System.out.println(getRow2(18));
		// System.out.println(getRow2(30));
		System.out.println(getRow2(13));
	}

}

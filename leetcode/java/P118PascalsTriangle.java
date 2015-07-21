package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P118PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
		for (int i = 0; i < numRows; i++) {
			list.add(getRow2(i));
		}
		return list;
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
				cn = Math.round(cn);
				r.add(i, (int) cn);
			}
		}
		for (int i = k; i < rowIndex + 1; i++) {
			r.add(i, r.get(rowIndex - i));
		}
		return r;

	}

	public static void main(String args[]) {
		System.out.println(generate(5));
	}

}

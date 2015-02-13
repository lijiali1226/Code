package euler;

import java.util.ArrayList;

public class P032PandigitalProducts {

	public static boolean isPandigital(String temp) {
		int i = 0, j = 0;
		if (temp.length() != 9)
			return false;
		for (i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == '0')
				return false;
			for (j = i + 1; j < temp.length(); j++) {
				if (temp.charAt(i) == temp.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int i = 0, j = 0;
		String s = "";
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (i = 1; i < 100; i++) {
			for (j = i + 1; j < 5000; j++) {
				s = Integer.toString(i) + Integer.toString(j) + Integer.toString(i * j);
				if (isPandigital(s) && !list.contains(i * j)) {
					list.add(i * j);
				}
			}
		}
		int sum = 0;
		for (i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		System.out.println(sum);
	}

}

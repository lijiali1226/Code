package leetcode;

import java.util.ArrayList;

public class P038CountAndSay_WrongUnderstanding {

	public static String countAndSay(int n) {
		String[] num = { "zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine", "ten" };
		String res = "";
		String temp = String.valueOf(countSequence(n));
		for (int i = 0; i < temp.length(); i++) {
			if (i % 2 == 0)
				res += num[temp.charAt(i) - '0'] + ' ';
			else {
				res += temp.charAt(i);
				if (temp.charAt(i - 1) >= '2')
					res += 's';
				res += ' ';
			}

		}
		return res;

	}

	public static int countSequence(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		for (int i = 1; i <= n; i++) {
			int temp = arr.get(i - 1);
			arr.add(countNext(temp));
		}
		return arr.get(n);

	}

	private static Integer countNext(int temp) {
		String s = String.valueOf(temp);
		String res = "";
		while (s.length() != 0) {
			int count = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(0) == s.charAt(j)) {
					count++;
				}
			}
			res += count;
			res += s.charAt(0);
			s = s.replaceAll(String.valueOf(s.charAt(0)), "");
		}
		int num = Integer.parseInt(res);
		return num;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(1));// 1 "one 1"
		System.out.println(countAndSay(2));// 11 "two 1s"
		System.out.println(countAndSay(3));// 21 "one 2 one 1"
		System.out.println(countAndSay(4));// 1211 "three 1s one 2"
	}
}

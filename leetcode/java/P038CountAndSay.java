package leetcode;

import java.util.ArrayList;

public class P038CountAndSay {

	public static String countAndSay(int n) {

		ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		for (int i = 1; i < n; i++) {
			String temp = arr.get(i - 1);
			arr.add(countNext(temp));
		}
		return arr.get(n - 1);

	}

	private static String countNext(String temp) {
		String res = "";
		for (int i = 0; i < temp.length(); i++) {
			int count = 1;
			for (int j = i + 1; j < temp.length(); j++) {
				if (temp.charAt(i) == temp.charAt(j)) {
					i++;
					count++;
				} else
					break;
			}
			res += count;
			res += temp.charAt(i);
		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(countAndSay(1));// 1
		System.out.println(countAndSay(2));// 11
		System.out.println(countAndSay(3));// 21
		System.out.println(countAndSay(4));// 1211
		System.out.println(countAndSay(5));// "111221"

	}

}

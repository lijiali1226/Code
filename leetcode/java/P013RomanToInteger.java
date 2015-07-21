package leetcode;

import java.util.HashMap;

public class P013RomanToInteger {

	public static int romanToInt(String s) {
		String[] array = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
				"IX", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",
				"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M",
				"MM", "MMM" };
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70,
				80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000,
				2000, 3000 };
		int n = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			if (s.startsWith(array[i])) {
				n += num[i];
				s = s.replaceFirst(array[i], "");
			}
		}
		return n;

	}

	public static int romanToInt2(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('M', 1000);
		map.put('D', 500);
		map.put('C', 100);
		map.put('L', 50);
		map.put('X', 10);
		map.put('V', 5);
		map.put('I', 1);
		int sum = 0, i = 0;
		for (i = s.length() - 1; i >= 1; i--) {
			if (map.get(s.charAt(i - 1)) < map.get(s.charAt(i))) {
				sum += -map.get(s.charAt(i - 1));
			} else
				sum += map.get(s.charAt(i - 1));
		}
		return sum + map.get(s.charAt(s.length() - 1));
	}

	public static void main(String[] args) {
		System.out.println(romanToInt2("CMXCIX"));// 999
		System.out.println(romanToInt2("XVI"));// 16
		System.out.println(romanToInt2("XCV"));// 95
		System.out.println(romanToInt2("MMMCMXCIX"));// 3999
		System.out.println(romanToInt2("VI"));// 6
		System.out.println(romanToInt2("MDCLXVI"));// 1666
		System.out.println(romanToInt2("MCMXCVI"));// 1996

	}

}

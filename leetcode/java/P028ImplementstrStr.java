package leetcode;

public class P028ImplementstrStr {
	public static int strStr(String haystack, String needle) {
		if (haystack.length() < needle.length())
			return -1;
		if (needle.length() == 0)
			return 0;

		for (int k = 0; k <= haystack.length() - needle.length(); k++) {
			int count = 0, i = 0;
			for (int j = k; j < haystack.length(); j++) {
				if (i < needle.length()
						&& needle.charAt(i) == haystack.charAt(j)) {
					i++;
					count++;
					if (count == needle.length()) {
						return j - count + 1;
					}
				} else {
					count = 0;
				}
			}
		}
		return -1;

	}

	public static void main(String args[]) {
		System.out.println(strStr("aabaabbbaabbbbabaaab", "abaa"));
		System.out.println(strStr("slifejwiof", ""));
		System.out.println(strStr("", "lsfijewf"));
		System.out.println(strStr("", ""));
		System.out.println(strStr("mississippi", "issipi"));
		System.out.println(strStr("mississippi", "issip"));
		System.out.println(strStr("a", "a"));
		// expected 1 0 -1 0 -1 4 0
	}
}

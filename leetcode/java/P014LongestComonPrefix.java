package leetcode;

public class P014LongestComonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		StringBuffer prefix = new StringBuffer(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() < prefix.length()) {
				prefix.delete(strs[i].length(), prefix.length());
				if (prefix.length() == 0)
					return "";
			}
			for (int j = 0; j < prefix.length(); j++) {
				if (prefix.charAt(j) == strs[i].charAt(j))
					continue;
				else
					prefix.delete(j, prefix.length());
			}
		}
		return prefix.toString();

	}

	public static void main(String args[]) {
		String[] s1 = { "laweiwj", "lawowiej", "lawsjfoijheu", "la" };
		String[] s2 = { "lewjiinh", "lewjioweiw", "lewjs" };
		String[] s3 = { "lseijwfi", "lsiejwio", "afoij" };
		String[] s4 = {};
		String[] s5 = { "abab", "aba", "" };
		System.out.println(longestCommonPrefix(s1));
		System.out.println(longestCommonPrefix(s2));
		System.out.println(longestCommonPrefix(s3));
		System.out.println(longestCommonPrefix(s4));
		System.out.println(longestCommonPrefix(s5));
		// expected la lewj "" "" ""
	}
}

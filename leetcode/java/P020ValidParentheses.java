package leetcode;

import java.util.ArrayList;

public class P020ValidParentheses {

	public static boolean isValid(String s) {
		int i = 0, n = s.length();
		if (n % 2 == 1)
			return false;

		ArrayList<Character> arrlist = new ArrayList<Character>();
		for (i = 0; i < n; i++) {
			arrlist.add(s.charAt(i));
		}
		for (i = 0; i < arrlist.size() / 2; i++) {
			// System.out.println(i+" "+arrlist);
			if ((arrlist.get(i) == '{' && arrlist.get(i + 1) == '}')
					|| (arrlist.get(i) == '(' && arrlist.get(i + 1) == ')')
					|| (arrlist.get(i) == '[' && arrlist.get(i + 1) == ']')) {
				arrlist.remove(i);
				arrlist.remove(i);
				i = -1;
				// System.out.println(i+" "+arrlist);
			}
		}
		if (arrlist.size() == 0)
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("([])"));
		System.out.println(isValid("("));
		System.out.println(isValid("[()}"));
		// expected true true false false true false false
	}

}

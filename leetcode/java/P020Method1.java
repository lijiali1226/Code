package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P020Method1 {

	public boolean isValid(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Character> pairs = new HashMap<Character, Character>();
		pairs.put('(', ')');
		pairs.put('{', '}');
		pairs.put('[', ']');

		Stack<Character> stack = new Stack<Character>();
		for (char c : chars) {
			if (pairs.containsKey(c)) {
				stack.push(pairs.get(c));
			} else {
				if (stack.isEmpty() || c != stack.pop())
					return false;
			}
		}
		return stack.isEmpty();
	}
}

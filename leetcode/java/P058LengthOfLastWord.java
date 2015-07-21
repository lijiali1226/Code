package leetcode;

public class P058LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		String[] strarr = s.split(" ");
		if (strarr.length > 0)
			return strarr[strarr.length - 1].length();
		else
			return 0;

	}

	public static void main(String args[]) {
		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWord("Hello "));
		System.out.println(lengthOfLastWord(" "));
		System.out.println(lengthOfLastWord(""));
		System.out.println(lengthOfLastWord("Hello World Java"));
		System.out.println(lengthOfLastWord("        "));
		// expected 5 5 0 0 4 0
	}
}

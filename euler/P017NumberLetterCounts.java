package euler;

public class P017NumberLetterCounts {

	public static void main(String[] args) {
		String words[] = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
				"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
				"thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred", "thousnad", "and" };
		String matrix[] = new String[1001];
		int i = 0;
		long sum = 0L;

		matrix[0] = "";
		for (i = 1; i <= 20; i++) {
			matrix[i] = words[i - 1]; // 1 - 20
		}

		for (i = 20; i <= 26; i++) {
			matrix[(i - 20) * 10 + 30] = words[i]; // 30 40 ... 90
		}

		for (i = 21; i <= 99; i++) {
			matrix[i] = matrix[(i / 10) * 10] + matrix[i % 10]; // 21 - 99
		}

		for (i = 100; i <= 900; i += 100) {
			matrix[i] = matrix[i / 100] + words[27]; // 100 200 ... 900
		}

		matrix[1000] = words[0] + words[28]; // 1000

		for (i = 101; i <= 999; i++) {
			if (i % 100 != 0)
				matrix[i] = matrix[(i / 100) * 100] + words[29] + matrix[i % 100]; // 101 - 999
		}

		for (i = 1; i <= 1000; i++) {
			System.out.println(i + " " + matrix[i]);
			sum += matrix[i].length();
		}
		System.out.println(sum);
	}

}

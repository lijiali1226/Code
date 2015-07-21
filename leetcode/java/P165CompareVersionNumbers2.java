package leetcode;

public class P165CompareVersionNumbers2 {

	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i = 0;

		for (i = 0; i < v1.length && i < v2.length; i++) {
			if (Integer.valueOf(v1[i]) == Integer.valueOf(v2[i]))
				continue;
			return Integer.valueOf(v1[i]) > Integer.valueOf(v2[i]) ? 1 : -1;
		}
		if (v1.length == v2.length)
			return 0;
		return (v1.length > v2.length ? (Integer.valueOf(v1[v1.length - 1]) != 0 ? 1 : 0) : (Integer
				.valueOf(v2[v2.length - 1]) != 0 ? -1 : 0));
	}

	public static void main(String[] args) {
		System.out.println(compareVersion("0.1", "1.1"));
		System.out.println(compareVersion("1.1", "1.2"));
		System.out.println(compareVersion("1.2", "13.37"));
		System.out.println(compareVersion("1.23", "1.2"));
		System.out.println(compareVersion("1.1", "1.1"));
		System.out.println(compareVersion("1", "0"));
		System.out.println(compareVersion("01", "1"));
		System.out.println(compareVersion("01", "1.1"));
		System.out.println(compareVersion("0.1", "0.0.1"));
		System.out.println(compareVersion("1", "1.0.0"));
		System.out.println(compareVersion("0.1", "1.0.0"));
		// expected -1 -1 -1 1 0 1 0 -1 1 0 -1

	}

}

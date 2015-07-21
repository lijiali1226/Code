package leetcode;

public class P165CompareVersionNumbers {

	public static int compareVersion(String version1, String version2) {
		String[] temp1 = version1.split("\\.");
		String[] temp2 = version2.split("\\.");
		Integer[] v1 = new Integer[temp1.length];
		Integer[] v2 = new Integer[temp2.length];
		int i = 0;

		for (i = 0; i < temp1.length; i++) {
			v1[i] = Integer.parseInt(temp1[i]);
		}
		for (i = 0; i < temp2.length; i++) {
			v2[i] = Integer.parseInt(temp2[i]);
		}

		for (i = 0; i < v1.length && i < v2.length; i++) {
			if (v1[i] > v2[i])
				return 1;
			if (v1[i] < v2[i])
				return -1;
		}
		if (v1.length > v2.length && v1[v1.length - 1] != 0)
			return 1;
		if (v1.length < v2.length && v2[v2.length - 1] != 0)
			return -1;
		return 0;
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
		// 0.1 < 1.1 < 1.2 < 13.37
		// expected -1 -1 -1 1 0 1 0 -1 1 0 -1
	}

}

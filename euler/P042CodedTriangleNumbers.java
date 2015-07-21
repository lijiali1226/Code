package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class P042CodedTriangleNumbers {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("D:\\exJava\\exworkspace\\euler\\p042_words.txt");
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String s = "";
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		br.close();
		s = sb.toString();
		// System.out.println(s);

		String[] strarray = s.split(",");

		int i = 0, j = 0;
		int n = strarray.length;

		int[] value = new int[n];
		for (i = 0; i < n; i++) {
			int m = strarray[i].length();
			for (j = 1; j < m - 1; j++) {
				value[i] += strarray[i].charAt(j) - 'A' + 1;
			}
			// System.out.println(value[i] + " " + strarray[i]);
		}

		ArrayList<Integer> triangle = new ArrayList<Integer>();
		for (i = 0; i < 200; i++) {
			triangle.add((i + 1) * (i + 2) / 2);
			// System.out.println(triangle.get(i));
		}

		int count = 0;
		for (i = 0; i < n; i++) {
			if (triangle.contains(value[i])) {
				count++;
				// System.out.println(i + " " + value[i]);
			}
		}
		System.out.println(count);
	}

}

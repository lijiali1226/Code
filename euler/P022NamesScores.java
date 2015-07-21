package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P022NamesScores {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("D:\\exJava\\exworkspace\\euler\\p022_names.txt");
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
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(strarray));
		Collections.sort(list);

		int i = 0, j = 0;
		int n = strarray.length;
		for (i = 0; i < n; i++) {
			strarray[i] = list.get(i);
			System.out.println(strarray[i] + " " + i);
		}
		int[] value = new int[n];
		for (i = 0; i < n; i++) {
			int m = strarray[i].length();
			for (j = 1; j < m - 1; j++) {
				value[i] += strarray[i].charAt(j) - 'A' + 1;
				// System.out.println(value[i] + " " + strarray[i].charAt(j));
			}
		}

		int sum = 0;
		for (i = 0; i < n; i++) {
			value[i] *= i + 1;
			sum += value[i];
			System.out.println(value[i]);
		}
		System.out.println(sum);
	}

}

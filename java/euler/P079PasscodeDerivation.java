package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P079PasscodeDerivation {

	// solve by hand is much easier

	public static String readFile() throws IOException {
		FileReader fr = new FileReader("D:\\exJava\\exworkspace\\euler\\p079_keylog.txt");
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String s = "";
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		br.close();
		s = sb.toString();
		return s;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[][] n = new int[10][1];
		int i = 0, j = 0, k = 1, temp = 0, num = 0, num2 = 0;
		String s = readFile();
		for (i = 0; i < s.length() - 3; i += 3) {
			for (j = i; j < s.length() - 1 && j < i + 3; j++) {
				num = s.charAt(j) - '0';
				num2 = s.charAt(j + 1) - '0';
				if (n[num][0] == 0) {
					n[num][0] = k;
					k++;
				}
				if (j != i + 2 && n[num2][0] != 0 && n[num][0] > n[num2][0]) {
					temp = n[num][0];
					n[num][0] = n[num2][0];
					n[num2][0] = temp;
				}
				// for (int m = 0; m < 10; m++) {
				// System.out.print(n[m][0]);
				// }
				// System.out.println();
			}
		}

		String result = "";
		for (i = 1; i < 10; i++) {
			for (j = 0; j < 10; j++) {
				if (n[j][0] == i) {
					result += j;
				}
			}
		}
		System.out.println(result);
	}

}

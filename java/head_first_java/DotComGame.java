

import java.util.ArrayList;
import java.util.Scanner;

import com.yntravelsky.zodiac.lijiali.DotCom;

/**
 * Guess three set three continuous numbers in 7X7 matrix, input [A-G][0-6]
 * 
 * @author ljl
 * @since 20140610
 */
class DotComGame {
	public static void main(String[] args) {
		DotCom a = new DotCom();
		int[] num = { 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < 3; i++) {
			num[i] = (int) (Math.random() * 5);
		}
		for (int i = 3; i < 6; i++) {
			num[i] = (int) (Math.random() * 7);
		}
		// change duplicate item
		for (int i = 3; i < 6; i++) {
			int tmp = num[i];
			for (int j = 3; j < i; j++) {
				if (tmp == num[j]) {
					num[j] = (int) (Math.random() * 7);
				}
			}
		}
		// cheat
		// for (int item : num) {
		// System.out.println(item);
		// }
		String[] c = { "A", "B", "C", "D", "E", "F", "G" };
		int[] num1 = { num[0], num[1], num[2] };
		String[] d = { c[num[3]], c[num[4]], c[num[5]] };
		ArrayList<String> e = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				e.add(d[i] + (num1[i] + j));
		}
		a.setLocationCells(e);
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("enter a string [A-G][0-6] (for example A0)");
			String s = a.checkYourself(input.nextLine());
			System.out.println(s);
		} while (e.size() != 0);
		input.close();
	}
}

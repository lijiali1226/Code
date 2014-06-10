
import java.util.Scanner;

import com.yntravelsky.zodiac.lijiali.SimpleDotCom;

/**
 * Guess three continuous numbers in 0-6
 * 
 * @author ljl
 * @since 20140609
 */
class SimpleDotComGame {
	public static void main(String[] args) {
		SimpleDotCom a = new SimpleDotCom();
		int number = (int) (Math.random() * 5);
		int[] b = { number, number + 1, number + 2 };
		a.setLocationCells(b);
		Scanner input = new Scanner(System.in);
		System.out.println("enter a number");
		String s = a.checkYourself(input.nextLine());
		do {
			System.out.println(s);
			System.out.println("enter a number");
			s = a.checkYourself(input.nextLine());
		} while (s.equals("miss") || s.equals("hit"));
		System.out.println(s);
		input.close();
	}
}

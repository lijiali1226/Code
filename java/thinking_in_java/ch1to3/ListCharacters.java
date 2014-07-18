package ch1to3;

public class ListCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (char c = 0; c < 128; c++) {
			if (c != 26)//ANSI Clear Screen
				System.out.println("value " + (int) c + " character " + c);
		}
	}

}

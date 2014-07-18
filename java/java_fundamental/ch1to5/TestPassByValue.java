package ch1to5;

public class TestPassByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 1;
		int num2 = 2;

		System.out.println("Before invoking the swap method, num1 is " + num1 + " num2 is " + num2);
		swap(num1, num2);

		System.out.println("After invoking the swap method, num1 is " + num1 + " num2 is " + num2);

	}

	public static void swap(int n1, int n2) {
		System.out.println("\tInside the swap method");
		System.out.println("\t\tBefore swapping n1 is " + n1 + " n2 is " + n2);

		int tmp = n1;
		n1 = n2;
		n2 = tmp;

		System.out.println("\t\tAfter swapping n1 is " + n1 + " n2 is " + n2);
	}

}

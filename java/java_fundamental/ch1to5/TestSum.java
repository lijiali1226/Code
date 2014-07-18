package ch1to5;

public class TestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float sum = 0;

		for (float i = 0.01f; i <= 1.0f; i += 0.01f)
			sum += i;

		System.out.println("The sum is " + sum);
	}

}

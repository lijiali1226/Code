package euler;

public class P004Method1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (long i = 1000000; i > 1000; i--) {
			String s = String.valueOf(i);
			if (s.equals(new StringBuffer(s).reverse().toString())) {
				for (long j = 999; j > 100; j--) {
					if (i % j == 0 && i / j < 1000) {
						System.out.println(i);
					}
				}
			}
		}
	}

}

package euler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class P029DistinctPowers {

	public static void main(String[] args) {
		final int N = 100;
		int a = 2, b = 2;
		BigInteger i = BigInteger.ZERO;
		Set<BigInteger> set = new HashSet<BigInteger>();

		for (a = 2; a <= N; a++) {
			for (b = 2; b <= N; b++) {
				i = BigInteger.valueOf(a).pow(b);
				set.add(i);
			}
		}

		System.out.println(set.size());
	}

}

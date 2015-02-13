package euler;

public class P015Test2 {

	static final int N = 3;
	static int i = 0;
	static int j = 0;
	static int count = 0;
	static int lattice[][] = new int[N][N];

	public static void traverse(int i, int j) {

		if (lattice[i][j] == 0) {
			System.out.println("i " + i + " j " + j);
			lattice[i][j] = 1;
		}
		if (i == N - 1 && j == N - 1) {
			count++;
			for (i = 0; i < N; i++) {
				for (j = 0; j < N; j++)
					lattice[i][j] = 0;
				traverse(0,0);
			}
		} else if (i + 1 < N) {
			if (lattice[i + 1][j] == 0)
				traverse(i + 1, j);
		} else if (j + 1 < N)
			if (lattice[i][j + 1] == 0)
				traverse(i, j + 1);
	}

	public static void main(String args[]) {
		traverse(0, 0);
		System.out.println(count);
	}
}
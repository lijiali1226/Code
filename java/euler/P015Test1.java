package euler;

public class P015Test1 {

	static int length = 3;
	static int number = length * length;
	static int matrix[][] = new int[number][number];
	static boolean visited[] = new boolean[number];
	static int count = 0;

	public static void traverse(int i) {
		int j = 0;
		visited[i] = true;
		for (j = 0; j < number; j++) {
			if (matrix[i][j] == 1 && !visited[j]) {
				System.out.println("i " + i + " j " + j);
				traverse(j);
			}
		}
	}

	public static void dfs() {
		int i = 0;
		for (i = 0; i < number; i++) {
			if (!visited[i]) {
				count++;
				traverse(i);
			}
		}

	}

	public static void main(String[] args) {

		int i = 0;
		for (i = 0; i < number - 1; i++) {
			if (i % length != length - 1) {
				matrix[i][i + 1] = 1;
			}
			if (i < number - length) {
				matrix[i][i + length] = 1;
			}
		}
		for (i = 0; i < number; i++) {
			visited[i] = false;
		}

		dfs();
		System.out.println(number - count);
	}

}

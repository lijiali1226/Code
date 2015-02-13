package euler;

public class P015LatticePaths {

	class Tree {
		int N = 3;

		class Node {
			int data;
			int i;
			int j;
			Node right;
			Node down;

			public Node(int i, int j) {
				this.i = i;
				this.j = j;
				data = i * N + j;
			}

			public void displayNode() {
				System.out.println("node " + data + " i " + i + " j " + j);
			}

		}

		public void setTree() {
			int i = 0, j = 0;
			for (i = 0; i < N; i++) {
				for (j = 0; j < N; j++) {
					
				}
			}

		}

	}

	public static void main(String args[]) {

	}
}

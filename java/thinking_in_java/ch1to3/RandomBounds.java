package ch1to3;

public class RandomBounds {

	public static void usage() {
		// TODO Auto-generated method stub
		System.err.println("Usage:\n\t" + "RandomBounds lower\n\t" + "RandomBounds upper");
		System.exit(1);
	}

	public static void main(String[] args) {
		if (args.length != 1)
			usage();
		if (args[0].equals("lower")) {
			while (Math.random() != 0.0)
				;// keep trying
			System.out.println("Produced 0.0!");
		} else if (args[0].equals("upper")) {
			while (Math.random() != 1.0)
				;// keep trying
			System.out.println("Produced 1.0!");
		} else
			usage();
	}

}

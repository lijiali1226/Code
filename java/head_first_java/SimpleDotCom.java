

public class SimpleDotCom {

	int[] locationCells = new int[7];
	int numOfHits = 0;
	int numOfGuess = 0;

	String checkYourself(String guess) {
		numOfGuess++;
		if (numOfHits == 2 && locationCells[Integer.parseInt(guess)] == 1)
			return "kill\n" + "You took " + numOfGuess + " guesses";
		if (locationCells[Integer.parseInt(guess)] == 1) {
			numOfHits++;
			// avoid duplicate
			locationCells[Integer.parseInt(guess)] = 0;
			return "hit";
		} else {
			return "miss";
		}
	}

	void setLocationCells(int[] loc) {
		for (int i = 0; i < loc.length; i++) {
			locationCells[loc[i]] = 1;
		}
	}
}

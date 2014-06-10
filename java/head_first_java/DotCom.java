
import java.util.ArrayList;

public class DotCom {

	ArrayList<String> locationCells;
	int numOfHits = 0;
	int numOfGuess = 0;

	String checkYourself(String guess) {
		numOfGuess++;
		if (numOfHits == 8 && locationCells.contains(guess)) {
			locationCells.remove(guess);
			return "ouch, you sunk c.com\n" + "You took " + numOfGuess + " guesses";
		}
		if (locationCells.contains(guess)) {
			numOfHits++;
			// avoid duplicate
			locationCells.remove(guess);
			if (numOfHits == 3) {
				return "ouch, you sunk a.com";
			}
			if (numOfHits == 6) {
				return "ouch, you sunk b.com";
			} else
				return "hit";
		} else {
			return "miss";
		}
	}

	void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}
}

package euler;

public class P019CountingSundays {
	static int count = 0;
	static int days = 365 % 7 + 1;

	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return true;
		return false;
	}

	public static void countDays(int month, int year) {
		int i = 0;

		for (i = 1; i < month; i++) {
			if (days % 7 == 0)
				count++;
			// System.out.println(year + " " + i + " " + days + " " + days % 7 + " " + count);
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days += 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days += 30;
				break;
			case 2:
				if (isLeapYear(year))
					days += 29;
				else
					days += 28;
				break;
			}

		}
	}

	public static void main(String args[]) {
		int i = 0;
		int startyear = 1901, endyear = 2000;
		for (i = startyear; i <= endyear; i++) {
			countDays(13, i);
		}
		System.out.println(count);
	}
}

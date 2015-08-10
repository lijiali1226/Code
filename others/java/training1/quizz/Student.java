package quizz;

public class Student {
	private long id;
	private char gender;
	private String name;
	private int age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		int N = 10, i = 0, j = 0;
		Student student[] = new Student[N];
		String name[] = { "ZHAO", "QIAN", "SUN", "LI", "ZHOU", "WU", "ZHENG", "WANG", "FENG", "CHEN" };

		// 创建数组
		for (i = 0; i < N; i++) {
			student[i] = new Student();
			student[i].setAge((int) (Math.random() * 6) + 10);
			student[i].setId((long) (Math.random() * 900_000_000 + 100_000_000));
			student[i].setGender(Math.random() <= 0.5 ? 'M' : 'F');
			student[i].setName(name[i]);
		}

		// 打印原数组
		System.out.println("AGE GENDER     ID    NAME");
		for (i = 0; i < N; i++) {
			System.out.println(student[i].getAge() + "   " + student[i].getGender() + "    " + student[i].getId()
					+ "  " + student[i].getName());
		}
		System.out.println();

		// 根据年龄冒泡排序
		for (i = 0; i < N; i++) {
			for (j = 0; j < N - i - 1; j++) {
				if (student[j + 1].getAge() < student[j].getAge()) {
					Student temp = new Student();
					temp = student[j + 1];
					student[j + 1] = student[j];
					student[j] = temp;
				}
			}
		}

		// 打印排序后数组
		for (i = 0; i < N; i++) {
			System.out.println(student[i].getAge() + "   " + student[i].getGender() + "    " + student[i].getId()
					+ "  " + student[i].getName());
		}

	}
}

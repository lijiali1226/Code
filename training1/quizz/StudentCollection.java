package quizz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentCollection implements Comparable<StudentCollection> {
	private long id;
	private char gender;
	private String name;
	private Integer age;
	private String major;

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

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String toString() {
		return "\n" + this.getId() + " " + this.getGender() + " " + this.getAge() + " " + this.getMajor() + " "
				+ this.getName();
	}

	public static void main(String[] args) {
		final int N = 10;
		List<StudentCollection> stuList = new ArrayList<StudentCollection>();
		List<String> nameList = new ArrayList<String>(Arrays.asList("ZHAO", "QIAN", "SUN", "LI", "ZHOU", "WU", "ZHENG",
				"WANG", "FENG", "CHEN"));
		List<String> majorList = new ArrayList<String>(Arrays.asList("CS", "CE", "EE"));

		// LIST初始化
		Iterator<String> it = nameList.iterator();
		while (stuList.size() != N && it.hasNext()) {
			StudentCollection student = new StudentCollection();
			student.setAge((int) (Math.random() * 6) + 10);
			student.setGender(Math.random() <= 0.5 ? 'M' : 'F');
			student.setId((long) (Math.random() * 900_000 + 100_000));
			student.setMajor(majorList.get((int) (Math.random() * 3)));
			student.setName(it.next());
			stuList.add(student);
		}

		// MAP初始化 ，key为ID，value为NAME
		Map<Long, String> nameMap = new HashMap<Long, String>();
		Iterator<StudentCollection> it2 = stuList.iterator();
		for (String s : nameList) {
			if (it2.hasNext()) {
				nameMap.put(it2.next().getId(), s);
			}
		}
		System.out.println(nameMap.entrySet());

		// SET初始化
		Set<String> majorSet = new HashSet<String>();
		for (StudentCollection student : stuList) {
			majorSet.add(student.getMajor());
		}
		System.out.println(majorSet.size());

		// 打印原LIST
		System.out.println("************original order**************");
		System.out.println("ID GENDER AGE MAJOR NAME");
		System.out.println(Arrays.toString(stuList.toArray()));

		// 按年齡排序輸出
		Collections.sort(stuList);
		System.out.println("************sort by age**************");
		System.out.println(Arrays.toString(stuList.toArray()));

		// 按学号排序输出
		Collections.sort(stuList, new Comparator<StudentCollection>() {

			@Override
			public int compare(StudentCollection o1, StudentCollection o2) {
				return (int) (o1.getId() - o2.getId());
			}

		});
		System.out.println("************sort by id**************");
		System.out.println(Arrays.toString(stuList.toArray()));
	}

	@Override
	public int compareTo(StudentCollection o) {
		
		return this.age.compareTo(o.age);
	}

}

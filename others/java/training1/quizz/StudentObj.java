package quizz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StudentObj implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private char gender;
	private String name;
	private int age;
	private double score;

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

	public double getScore() {
		return score;
	}

	public void setScore(double d) {
		this.score = d;
	}

	public String toString() {
		return name + " " + age + " " + id + " " + gender + " " + score;

	}

	public static void readWriteByteStreamFile(StudentObj stu, File file)
			throws IOException {
		// 创建字节流文件
		System.out.println("Write to " + file);
		FileOutputStream fout = new FileOutputStream(file);
		DataOutputStream dout = new DataOutputStream(fout);
		// dout.writeChars(stu.getName());
		dout.writeUTF(stu.getName());
		dout.writeInt(stu.getAge());
		dout.writeLong(stu.getId());
		dout.writeChar(stu.getGender());
		dout.writeDouble(stu.getScore());
		dout.close();

		// 读文件且打印到标准输出
		System.out.println("Read from " + file + ":");
		FileInputStream fin = new FileInputStream(file);
		DataInputStream din = new DataInputStream(fin);
		// for (int i = 0; i < stu.getName().length(); i++) {
		// System.out.print(din.readChar());
		// }
		System.out.print(din.readUTF() + " ");
		System.out.print(din.readInt() + " ");
		System.out.print(din.readLong() + " ");
		System.out.print(din.readChar() + " ");
		System.out.println(din.readDouble() + " ");
		System.out.println();
		din.close();
	}

	public static void readWriteCharStreamFile(StudentObj stu, File file)
			throws IOException {
		// 创建字符流文件
		System.out.println("Write to " + file);
		FileWriter fwout = new FileWriter(file);
		String str = stu.toString();
		fwout.write(str);
		fwout.close();

		// 读文件且打印到标准输出
		System.out.println("Read from " + file + ":");
		FileReader frin = new FileReader(file);
		char[] chars = new char[str.length()];
		while (frin.read(chars) != -1) {
			System.out.println(chars);
		}
		System.out.println();
		frin.close();
	}

	public static void readWriteObjectStreamFile(StudentObj stu, File file)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		// 创建对象流文件
		System.out.println("Write to " + file);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				file));
		out.writeObject(stu);
		out.close();

		// 读文件且打印到标准输出
		System.out.println("Read from " + file + ":");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		System.out.println(in.readObject());
		in.close();

	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		// 创建对象
		StudentObj stu = new StudentObj();
		stu.setName("Lijiali");
		stu.setAge(24);
		stu.setId(12345);
		stu.setGender('F');
		stu.setScore(99.9);
		System.out.println("Original text: " + stu.toString());
		System.out.println();

		// 创建文件夹及文件
		File dir = new File("c:\\" + stu.getName());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file1 = new File(dir, "1.dat");
		File file2 = new File(dir, "2.txt");
		File file3 = new File(dir, "3.dat");

		// 文件读写操作
		readWriteByteStreamFile(stu, file1);
		readWriteCharStreamFile(stu, file2);
		readWriteObjectStreamFile(stu, file3);
	}
}

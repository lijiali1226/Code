package quizz;

import java.lang.reflect.Method;

class TimestampCall {
	@Timestamp(index = 1, date = "03/04/2015")
	public TimestampCall() {
	}

	@Timestamp(index = 2, date = "03/04/2015", developer = "A")
	public void student() {
	}

	@Timestamp(index = 3, date = "03/04/2015", developer = "B")
	public void test() {
	}

	public void test2() {

	}
}

class TimestampTest {
	public static void main(String args[]) {
		Method[] methods = TimestampCall.class.getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].isAnnotationPresent(Timestamp.class)) {
				Timestamp timestamp = methods[i].getAnnotation(Timestamp.class);
				System.out.println("method: " + methods[i].getName());
				System.out.println("index: " + timestamp.index());
				System.out.println("date: " + timestamp.date());
				System.out.println("developer: " + timestamp.developer());
				System.out.println(timestamp.toString());
				System.out.println();

			}
		}
	}

}
package quizz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentReflection {

	public static void main(String args[]) {
		try {
			Class<?> clazz = Class.forName("quizz.StudentEnum");
			Object obj = clazz.newInstance();
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().equals("setName")) {
					method.invoke(obj, "Alice");
				}
			}
			Method method = clazz.getMethod("setId", long.class);
			method.invoke(obj, 654789789);

			System.out.println(obj);
			System.out.println(obj.toString());
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		} catch (NoSuchMethodException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}
	}

}

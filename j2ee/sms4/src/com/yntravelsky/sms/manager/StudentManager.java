package com.yntravelsky.sms.manager;

import java.util.List;

import com.yntravelsky.sms.model.Student;

public interface StudentManager {
	public abstract void add(Student u);

	public abstract boolean exists(Student u) throws Exception;

	public abstract List<Student> getStudents();

	public abstract Student loadById(int id);
	
	public abstract Student loadByName(String name);

	public abstract void delete(Student u);

	public abstract void update(Student u);

}

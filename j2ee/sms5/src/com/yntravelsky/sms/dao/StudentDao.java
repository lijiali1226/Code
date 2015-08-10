package com.yntravelsky.sms.dao;

import java.util.List;

import com.yntravelsky.sms.model.Student;

public interface StudentDao {
	public void save(Student u);

	public boolean checkStudentExistsWithName(String name);

	public List<Student> getStudents();

	public Student loadById(int id);
	
	public Student loadByName(String name);

	public void delete(Student u);

	public void update(Student u);
}

package com.yntravelsky.sms.dao;

import java.util.List;

import com.yntravelsky.sms.model.Course;

public interface CourseDao {
	public void save(Course u);

	public boolean checkCourseExistsWithName(String name);

	public List<Course> getCourses();

	public Course loadById(int id);
	
	public List<Course> loadByName(String name);
	
	public List<Course> loadByStudentName(String name);

	public void delete(Course u);

	public void update(Course u);
}

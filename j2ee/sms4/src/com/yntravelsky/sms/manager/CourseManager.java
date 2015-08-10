package com.yntravelsky.sms.manager;

import java.util.List;

import com.yntravelsky.sms.model.Course;

public interface CourseManager {
	public abstract void save(Course u);

	public abstract boolean checkCourseExistsWithName(String name);

	public abstract List<Course> getCourses();

	public abstract Course loadById(int id);
	
	public abstract List<Course> loadByName(String name);
	
	public abstract List<Course> loadByStudentName(String name);

	public abstract void delete(Course u);

	public abstract void update(Course u);
}

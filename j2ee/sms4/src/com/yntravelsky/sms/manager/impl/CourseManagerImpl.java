package com.yntravelsky.sms.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yntravelsky.sms.dao.CourseDao;
import com.yntravelsky.sms.manager.CourseManager;
import com.yntravelsky.sms.model.Course;

@Component("courseManager")
public class CourseManagerImpl implements CourseManager{

	private CourseDao courseDao;
	
	public CourseDao getCourseDao() {
		return courseDao;
	}

	@Resource
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public void save(Course u) {
		courseDao.save(u);
	}

	@Override
	public boolean checkCourseExistsWithName(String name) {
		return courseDao.checkCourseExistsWithName(name);
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.getCourses();
	}

	@Override
	public Course loadById(int id) {
		return courseDao.loadById(id);
	}

	@Override
	public List<Course> loadByName(String name) {
		return courseDao.loadByName(name);
	}

	
	@Override
	public void delete(Course u) {
		courseDao.delete(u);
	}

	@Override
	public void update(Course u) {
		courseDao.update(u);
	}

	@Override
	public List<Course> loadByStudentName(String name) {
		return courseDao.loadByStudentName(name);
	}
}

package com.yntravelsky.sms.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yntravelsky.sms.dao.StudentDao;
import com.yntravelsky.sms.manager.StudentManager;
import com.yntravelsky.sms.model.Student;

@Component("studentManager")
public class StudentManagerImpl implements StudentManager {
	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	@Resource
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void add(Student u) {
		studentDao.save(u);

	}

	@Override
	public boolean exists(Student u) throws Exception {
		return studentDao.checkStudentExistsWithName(u.getName());
	}

	@Override
	public List<Student> getStudents() {
		return studentDao.getStudents();
	}

	@Override
	public Student loadById(int id) {
		return studentDao.loadById(id);
	}

	@Override
	public void delete(Student u) {
		studentDao.delete(u);
	}

	@Override
	public void update(Student u) {
		studentDao.update(u);
	}

	@Override
	public Student loadByName(String name) {
		return studentDao.loadByName(name);
	}

}

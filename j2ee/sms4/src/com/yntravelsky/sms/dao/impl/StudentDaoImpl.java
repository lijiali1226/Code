package com.yntravelsky.sms.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.yntravelsky.sms.dao.StudentDao;
import com.yntravelsky.sms.model.Student;

@Transactional
@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Student u) {
		sessionFactory.getCurrentSession().save(u);
	}

	@Override
	public boolean checkStudentExistsWithName(String name) {
		if (this.loadByName(name)!=null)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from Student").list();
	}

	@Override
	public Student loadById(int id) {
		return (Student) this.sessionFactory.getCurrentSession().load(
				Student.class, id);
	}

	public Student loadByName(String name) {
		return (Student)this.sessionFactory.getCurrentSession()
				.createQuery("from Student u where u.name='" + name + "'").uniqueResult();
	}
	
	@Override
	public void delete(Student u) {
		this.sessionFactory.getCurrentSession().delete(u);
		
	}

	@Override
	public void update(Student u) {
		this.sessionFactory.getCurrentSession().update(u);
	}

}

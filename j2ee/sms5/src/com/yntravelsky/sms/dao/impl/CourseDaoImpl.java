package com.yntravelsky.sms.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.yntravelsky.sms.dao.CourseDao;
import com.yntravelsky.sms.model.Course;

@Transactional
@Component("courseDao")
public class CourseDaoImpl implements CourseDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Course u) {
		this.sessionFactory.getCurrentSession().save(u);
	}

	@Override
	public boolean checkCourseExistsWithName(String name) {
		if (this.loadByName(name).size() > 0)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCourses() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from Course").list();
	}

	@Override
	public Course loadById(int id) {
		return (Course) this.sessionFactory.getCurrentSession().load(
				Course.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> loadByName(String name) {
		return this.sessionFactory.getCurrentSession().createQuery("from Course u where u.name='"+name+"'")
				.list();
	}

	@Override
	public void delete(Course u) {
		this.sessionFactory.getCurrentSession().delete(u);
	}

	@Override
	public void update(Course u) {
		this.sessionFactory.getCurrentSession().update(u);
	}

	
	@SuppressWarnings("unchecked")
	public List<Course> loadByStudentName(String name) {
		return this.sessionFactory.getCurrentSession().createQuery("from Course u where u.student.name='"+name+"'").list();
	}

}

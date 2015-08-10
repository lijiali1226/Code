package com.yntravelsky.sms.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yntravelsky.sms.manager.CourseManager;
import com.yntravelsky.sms.manager.StudentManager;
import com.yntravelsky.sms.model.Course;

@Resource(name = "course")
@Scope("prototype")
public class CourseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Course course;

	private List<Course> courses;
	private List<Course> courses_result;
	
	private StudentManager studentManager;
	private CourseManager courseManager;

	public CourseAction() {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-applicationContext.xml");
		courseManager = (CourseManager) ctx.getBean("courseManager");
		studentManager = (StudentManager) ctx.getBean("studentManager");
	}

	public String add() {
		Course u = new Course();
		u.setName(course.getName());
		u.setScore(course.getScore());
		u.setStudent(studentManager.loadByName(course.getStudent().getName()));
		courseManager.save(u);
		return SUCCESS;
	}

	public String addInput() {
		return INPUT;
	}

	public String delete() {
		Course u = this.courseManager.loadById(id);
		this.courseManager.delete(u);
		return SUCCESS;
	}

	public String list() {
		this.courses = this.courseManager.getCourses();
		return SUCCESS;
	}

	public String searchByCourse() {
		this.courses_result = this.courseManager.loadByName(course.getName());
		if (courses_result.size() > 0)
			return SUCCESS;
		return "fail";
	}

	public String searchByStudent() {
		this.courses_result = this.courseManager.loadByStudentName(course.getStudent()
				.getName());
		if (courses_result.size() > 0)
			return SUCCESS;
		return "fail";
	}

	public String searchInput() {
		return INPUT;
	}

	public String update() {
		Course u = new Course();
		u.setId(course.getId());
		u.setStudent(this.studentManager.loadByName(course.getStudent().getName()));
		u.setName(course.getName());
		u.setScore(course.getScore());
		this.courseManager.update(u);
		return SUCCESS;
	}

	public String updateInput() {
		this.course = this.courseManager.loadById(id);
		return INPUT;
	}

	public Course getCourse() {
		return course;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public CourseManager getCourseManager() {
		return courseManager;
	}

	public int getId() {
		return id;
	}

	public StudentManager getStudentManager() {
		return studentManager;
	}

	public List<Course> getCourses_result() {
		return courses_result;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Resource
	public void setCourseManager(CourseManager courseManager) {
		this.courseManager = courseManager;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Resource
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	public void setCourses_result(List<Course> courses_result) {
		this.courses_result = courses_result;
	}

}

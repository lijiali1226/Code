package com.yntravelsky.sms.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yntravelsky.sms.manager.StudentManager;
import com.yntravelsky.sms.model.Student;

@Resource(name = "student")
@Scope("prototype")
public class StudentAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Student student;
	private List<Student> students;
	private StudentManager studentManager;

	public StudentAction() {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-applicationContext.xml");
		studentManager = (StudentManager) ctx.getBean("studentManager");
	}

	public String add() throws Exception {
		Student u = new Student();
		u.setName(student.getName());
		if (studentManager.exists(u))
			return "fail";
		else
			studentManager.add(u);
		return SUCCESS;
	}

	public String addInput() {
		return INPUT;
	}

	public String delete() throws Exception {
		Student u = studentManager.loadById(id);
		studentManager.delete(u);
		return SUCCESS;
	}

	public String list() {
		this.students = studentManager.getStudents();
		return SUCCESS;
	}

	public String search() throws Exception {
		this.student=studentManager.loadByName(student.getName());
		if (student==null)
			return "fail";
		else
		return SUCCESS;
	}

	public String searchInput() {
		return INPUT;
	}

	public String update() throws Exception {
		Student u = new Student();
		u.setId(student.getId());
		u.setName(student.getName());
		studentManager.update(u);
		return SUCCESS;
	}

	public String updateInput() {
		this.student=this.studentManager.loadById(id);
		return INPUT;
	}

	public int getId() {
		return id;
	}

	public Student getStudent() {
		return student;
	}

	public StudentManager getStudentManager() {
		return studentManager;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Resource
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}

package com.yntravelsky.sms.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yntravelsky.sms.manager.StudentManager;
import com.yntravelsky.sms.model.Student;

@Controller
public class StudentController {

	private Student student;
	private StudentManager studentManager;

	@RequestMapping(value = "/Student_add")
	public String add(@ModelAttribute("student") Student student)
			throws Exception {
		if (studentManager.exists(student))
			return "error";
		else
			studentManager.add(student);
		return "redirect:Student_list";
	}

	@RequestMapping(value = "/Student_delete")
	public String delete(@RequestParam("id") int id) {
		Student u = studentManager.loadById(id);
		studentManager.delete(u);
		return "redirect:Student_list";
	}

	@RequestMapping(value = "/Student_list")
	public String list(Model model) throws Exception {
		model.addAttribute("students", studentManager.getStudents());
		return "Student_list";
	}

	@RequestMapping(value = "/Student_search")
	public String search(@RequestParam("name") String name) {
		this.student = studentManager.loadByName(name);
		if (student == null)
			return "error";
		return "redirect:Student_list";
	}

	@RequestMapping(value = "/Student_update")
	public String update(@ModelAttribute("student") Student student) {
		studentManager.update(student);
		return "redirect:Student_list";
	}

	@RequestMapping(value = "/Student_updateInput")
	public String updateInput(@RequestParam("id") int id, Model model) {
		model.addAttribute("student", studentManager.loadById(id));
		return "Student_updateInput";
	}

	@ModelAttribute("student_result")
	public Student getStudent() {
		return student;
	}

	public StudentManager getStudentManager() {
		return studentManager;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Resource
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

}

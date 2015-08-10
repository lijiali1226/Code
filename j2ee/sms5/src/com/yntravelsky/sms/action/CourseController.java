package com.yntravelsky.sms.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yntravelsky.sms.manager.CourseManager;
import com.yntravelsky.sms.manager.StudentManager;
import com.yntravelsky.sms.model.Course;

@Controller
public class CourseController {
	
	private List<Course> courses_result;

	private StudentManager studentManager;
	private CourseManager courseManager;

	@RequestMapping("/Course_add")
	public String add(@ModelAttribute("course") Course course) {
		Course u = new Course();
		u.setName(course.getName());
		u.setScore(course.getScore());
		u.setStudent(this.studentManager.loadByName(course.getStudent()
				.getName()));
		courseManager.save(u);
		return "redirect:Course_list";
	}

	@RequestMapping("/Course_delete")
	public String delete(@RequestParam("id") int id) {
		Course u = this.courseManager.loadById(id);
		this.courseManager.delete(u);
		return "redirect:Course_list";
	}

	@RequestMapping("/Course_list")
	public String list(Model model) {
		model.addAttribute("courses", this.courseManager.getCourses());
		return "Course_list";
	}

	@RequestMapping("/Course_searchByCourse")
	public String searchByCourse(@RequestParam("name") String name) {
		this.courses_result = this.courseManager.loadByName(name);
		if (courses_result.size() > 0)
			return "redirect:Course_list";
		return "error";
	}

	@RequestMapping("/Course_searchByStudent")
	public String searchByStudent(@RequestParam("student.name") String name) {
		this.courses_result = this.courseManager.loadByStudentName(name);
		if (courses_result.size() > 0)
			return "redirect:Course_list";
		return "error";
	}

	@RequestMapping("/Course_update")
	public String update(@ModelAttribute("course") Course course) {
		Course u = new Course();
		u.setId(course.getId());
		u.setStudent(this.studentManager.loadByName(course.getStudent()
				.getName()));
		u.setName(course.getName());
		u.setScore(course.getScore());
		this.courseManager.update(u);
		return "redirect:Course_list";
	}

	@RequestMapping("/Course_updateInput")
	public String updateInput(@RequestParam("id") int id, Model model) {
		model.addAttribute("course", this.courseManager.loadById(id));
		return "Course_updateInput";
	}


	public CourseManager getCourseManager() {
		return courseManager;
	}

	
	@ModelAttribute("courses_result")
	public List<Course> getCourses_result() {
		return courses_result;
	}

	public StudentManager getStudentManager() {
		return studentManager;
	}

	@Resource
	public void setCourseManager(CourseManager courseManager) {
		this.courseManager = courseManager;
	}


	public void setCourses_result(List<Course> courses_result) {
		this.courses_result = courses_result;
	}

	@Resource
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}
}

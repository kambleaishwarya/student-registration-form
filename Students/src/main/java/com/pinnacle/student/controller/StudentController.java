package com.pinnacle.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pinnacle.student.model.Student;
import com.pinnacle.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String showHomePage() {
		return "homePage";
	}

	@GetMapping("/register")
	public String showRegistration() {
		return "registerStudentPage";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student, Model model) {
		service.saveStudent(student);
		Long id = service.saveStudent(student).getId();
		String message = "Record with id : '" + id + "' is saved successfully !";
		model.addAttribute("message", message);
		return "registerStudentPage";
	}

	@GetMapping("/getAllStudents")
	public String getAllStudents(@RequestParam(value = "message", required = false) String message, Model model) {
		List<Student> students = service.getAllStudent();
		model.addAttribute("list", students);
		model.addAttribute("message", message);
		return "allStudentsPage";
	}

	@GetMapping("/edit")
	public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam Long id) {
		String page = null;
		try {
			Student student = service.getStudentById(id);
			model.addAttribute("student", student);
			page = "editStudentPage";
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:getAllStudents";
		}
		return page;
	}

	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student student, RedirectAttributes attributes) {
		service.updateStudent(student);
		Long id = student.getId();
		attributes.addAttribute("message", "Student with id: '" + id + "' is updated successfully !");
		return "redirect:getAllStudents";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam Long id, RedirectAttributes attributes) {
		try {
			service.deleteStudentById(id);
			attributes.addAttribute("message", "Student with Id : '" + id + "' is removed successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:getAllStudents";
	}

	@GetMapping("/courses")
	public String getCourses(Model model) {
		Map<String, List<Student>> coursesWithStudents = service.listOfStudentsByCourse();
		model.addAttribute("coursesWithStudents", coursesWithStudents);
		return "studentCoursesPage";
	}

	@GetMapping("/balanceFees")
	public String getBalanceFees(Model model) {
		List<Student> studentsWithBalanceFees = service.listOfStudentsBalanceFees();
		model.addAttribute("studentsWithBalanceFees", studentsWithBalanceFees);
		return "studentBalanceFeesPage";
	}

	@GetMapping("/coursesWithBalanceFees")
	public String getCoursesWithBalanceFees(Model model) {
		Map<String, List<Student>> coursesWithBalanceFees = service.listOfStudentsCourseBalanceFees();
		model.addAttribute("coursesWithBalanceFees", coursesWithBalanceFees);
		return "studentCoursesBalanceFeesPage";
	}

}

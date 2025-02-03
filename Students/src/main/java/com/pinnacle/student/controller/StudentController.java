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

import jakarta.validation.Valid;

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
	public String saveStudent(@Valid @ModelAttribute Student student, Model model) {
		try {
			service.saveStudent(student);
			Long id = student.getId();
			String message = "Record with id : '" + id + "' is saved successfully!";
			model.addAttribute("message", message);
		} catch (Exception e) {
			model.addAttribute("error", "Error saving student: " + e.getMessage());
		}
		return "registerStudentPage";
	}
	

	@GetMapping("/getAllStudents")
	public String getAllStudents(@RequestParam(value = "message", required = false) String message, Model model) {
		try {
			List<Student> students = service.getAllStudent();
			model.addAttribute("list", students);
			model.addAttribute("message", message);
		} catch (Exception e) {
			model.addAttribute("error", "Error fetching all students: " + e.getMessage());
		}
		return "allStudentsPage";
	}

	@GetMapping("/edit")
	public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam Long id) {
		String page;
		try {
			Student student = service.getStudentById(id);
			model.addAttribute("student", student);
			page = "editStudentPage";
		} catch (Exception e) {
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:getAllStudents";
		}
		return page;
	}

	@PostMapping("/update")
	public String updateStudent(@Valid @ModelAttribute Student student, RedirectAttributes attributes) {
		try {
			service.updateStudent(student);
			Long id = student.getId();
			attributes.addAttribute("message", "Student with id: '" + id + "' is updated successfully!");
		} catch (Exception e) {
			attributes.addAttribute("error", "Error updating student: " + e.getMessage());
		}
		return "redirect:getAllStudents";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam Long id, RedirectAttributes attributes) {
		try {
			service.deleteStudentById(id);
			attributes.addAttribute("message", "Student with Id : '" + id + "' is removed successfully!");
		} catch (Exception e) {
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:getAllStudents";
	}

	@GetMapping("/courses")
	public String getCourses(Model model) {
		try {
			Map<String, List<Student>> coursesWithStudents = service.listOfStudentsByCourse();
			model.addAttribute("coursesWithStudents", coursesWithStudents);
		} catch (Exception e) {
			model.addAttribute("error", "Error fetching courses: " + e.getMessage());
		}
		return "studentCoursesPage";
	}

	@GetMapping("/balanceFees")
	public String getBalanceFees(Model model) {
		try {
			List<Student> studentsWithBalanceFees = service.listOfStudentsBalanceFees();
			model.addAttribute("studentsWithBalanceFees", studentsWithBalanceFees);
		} catch (Exception e) {
			model.addAttribute("error", "Error fetching students with balance fees: " + e.getMessage());
		}
		return "studentBalanceFeesPage";
	}

	@GetMapping("/coursesWithBalanceFees")
	public String getCoursesWithBalanceFees(Model model) {
		try {
			Map<String, List<Student>> coursesWithBalanceFees = service.listOfStudentsCourseBalanceFees();
			model.addAttribute("coursesWithBalanceFees", coursesWithBalanceFees);
		} catch (Exception e) {
			model.addAttribute("error", "Error fetching courses with balance fees: " + e.getMessage());
		}
		return "studentCoursesBalanceFeesPage";
	}

}

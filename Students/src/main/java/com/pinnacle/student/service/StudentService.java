package com.pinnacle.student.service;

import java.util.List;
import java.util.Map;

import com.pinnacle.student.model.Student;

public interface StudentService {

	public Student saveStudent(Student student);

	public List<Student> getAllStudent();

	public Student getStudentById(Long id) throws Exception;

	public void deleteStudentById(Long id);

	public void updateStudent(Student student);

	public Map<String, List<Student>> listOfStudentsByCourse();

	public List<Student> listOfStudentsBalanceFees();

	public Map<String, List<Student>> listOfStudentsCourseBalanceFees();

}

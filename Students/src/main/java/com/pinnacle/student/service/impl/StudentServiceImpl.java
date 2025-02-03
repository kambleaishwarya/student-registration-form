package com.pinnacle.student.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinnacle.student.model.Student;
import com.pinnacle.student.repository.StudentRepository;
import com.pinnacle.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }
	@Override
	public Student saveStudent(Student student) {

		return repository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {

		return repository.findAll();
	}

	@Override
	public Student getStudentById(Long id) throws Exception {

		Optional<Student> opt = repository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new Exception("Invoice with Id : " + id + " Not Found");
		}
	}

	@Override
	public void deleteStudentById(Long id) {
		Student student = repository.findById(id).orElse(null);

		if (student != null) {
			repository.delete(student);
		} else {
			throw new RuntimeException("Student not found with id: " + id);
		}
	}

	@Override
	public void updateStudent(Student student) {
		repository.save(student);
	}

	@Override
	public Map<String, List<Student>> listOfStudentsByCourse() {
		return getAllStudent().stream().collect(Collectors.groupingBy(Student::getCourse));
	}

	@Override
	public List<Student> listOfStudentsBalanceFees() {
		return getAllStudent().stream()
				.filter(student -> student.getBalanceFees() != null && student.getBalanceFees() > 0)
				.collect(Collectors.toList());
	}

	@Override
	public Map<String, List<Student>> listOfStudentsCourseBalanceFees() {
		return getAllStudent().stream()
				.filter(student -> student.getBalanceFees() != null && student.getBalanceFees() > 0)
				.collect(Collectors.groupingBy(Student::getCourse));
	}

}

package com.pinnacle.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pinnacle.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

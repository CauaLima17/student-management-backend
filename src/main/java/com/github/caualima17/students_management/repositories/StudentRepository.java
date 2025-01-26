package com.github.caualima17.students_management.repositories;

import com.github.caualima17.students_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

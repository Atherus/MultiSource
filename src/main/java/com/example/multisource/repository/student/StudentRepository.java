package com.example.multisource.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.multisource.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

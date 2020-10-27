package com.example.multisource.service;

import org.springframework.stereotype.Service;

import com.example.multisource.repository.student.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public void findAll() {

        studentRepository.findAll().forEach(student -> System.out.println("ID:" + student.getId()));
    }

}

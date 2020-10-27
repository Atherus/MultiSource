package com.example.multisource.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.multisource.service.BookService;
import com.example.multisource.service.StudentService;

@RequestMapping(path = "")
@RestController
public class MyResource {

    private final StudentService studentService;

    private final BookService bookService;

    public MyResource(StudentService studentService, BookService bookService) {

        this.studentService = studentService;
        this.bookService = bookService;
    }

    @GetMapping(path = "/read-all")
    public void readAll() {

        studentService.findAll();
        bookService.findAll();
    }
}

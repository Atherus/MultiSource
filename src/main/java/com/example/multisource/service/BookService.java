package com.example.multisource.service;

import org.springframework.stereotype.Service;

import com.example.multisource.repository.book.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public void findAll() {

        bookRepository.findAll().forEach(book -> System.out.println("ID BOOK: " + book.getId()));
    }

}

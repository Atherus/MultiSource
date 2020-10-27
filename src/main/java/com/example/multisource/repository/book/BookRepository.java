package com.example.multisource.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.multisource.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}

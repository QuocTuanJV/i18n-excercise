package com.tuanlq.midexam.services;

import com.tuanlq.midexam.model.Book;
import com.tuanlq.midexam.model.Category;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);
    Book findById(Long id);
    void save(Book book);
    void remove(Long id);
    Iterable<Book> findAllByCategory(Category category);
    Page<Book> findAllByNameContaining(String name, Pageable pageable);
}

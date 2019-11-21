package com.tuanlq.midexam.services.impl;

import com.tuanlq.midexam.model.Category;
import com.tuanlq.midexam.model.Book;
import com.tuanlq.midexam.repositories.BookRepository;
import com.tuanlq.midexam.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public Iterable<Book> findAllByCategory(Category category) {
        return bookRepository.findAllByCategory(category);
    }

    @Override
    public Page<Book> findAllByNameContaining(String name, Pageable pageable) {
        return bookRepository.findAllByNameContaining(name, pageable);
    }
}